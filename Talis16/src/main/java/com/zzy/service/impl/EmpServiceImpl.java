package com.zzy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzy.mapper.EmpExprMapper;
import com.zzy.mapper.EmpLogMapper;
import com.zzy.mapper.EmpMapper;
import com.zzy.pojo.*;
import com.zzy.service.EmpLogService;
import com.zzy.service.EmpService;
import com.zzy.utils.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService logService;



    /*@Override
    public PageResult queryPage(Integer page, Integer pageSize) {

//        traditional way for paging
        */
    /*
        Long total = empMapper.total();

        int start = (page - 1) * pageSize;
        List<Emp> emps = empMapper.queryPage(start, pageSize);
*/
    /*

//        page helper api
        PageHelper.startPage(page,pageSize);
//        can only do paging this query, if there is another query needs to paging, it cannot do it.
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;

        return new PageResult(p.getTotal(), p.getResult());

    }*/


    @Override
    public PageResult queryPage(QueryParam param, Integer page, Integer pageSize) {

        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.search(param);
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult(p.getTotal(),p.getResult());
    }


//    (rollbackFor = Exception.class) no matter which kind of exception will roll back the transaction
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(Emp emp) throws Exception {

        try {
//        1. implement emp info
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());

//        2. save info into DB
            empMapper.insert(emp);

//        int i = 1/0;

//        will throw the exception, but still commit the transaction

        /*if (true){
            throw new Exception("there is exception~");
        }*/

//        not safe, what if emp.getExprList() is null
      /*
        Integer empId = emp.getId();
        emp.getExprList().forEach(empExpr -> empExpr.setEmpId(empId));
        empExprMapper.insertExpr(emp.getExprList());
*/
//        3. store a batch of expr
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(empExpr -> empExpr.setEmpId(empId));
                empExprMapper.insertExpr(exprList);
            }
        } finally {
//            record operation log
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            logService.insertLog(empLog);
        }


    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIds(List<Integer> ids) {

//        1. delete basic emp info from emp table
        empMapper.deleteEmp(ids);

//        2. delete according emp_expr from emp_expr table
        empExprMapper.deleteEmpExpr(ids);

    }

    @Override
    public Emp searchById(Integer id) {
        return empMapper.searchById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {

        emp.setUpdateTime(LocalDateTime.now());

//        1. update basic emp->emp table
        empMapper.update(emp);

        //        2. update empExpr -> emp_expr table
        //        2.1 delete previous empExpr
//        *******cannot judge empty first, because maybe user just delete previous empExpr that's why the empExpr is empty ******
        empExprMapper.deleteEmpExpr(Arrays.asList(emp.getId()));

        Integer empId = emp.getId();

        List<EmpExpr> exprList = emp.getExprList();

        if (!CollectionUtils.isEmpty(exprList)){

            log.info("exprList has empId?:{}",exprList);

            exprList.forEach(empExpr -> empExpr.setEmpId(empId));

            //        2.2 insert new empExpr
            empExprMapper.insertExpr(exprList);

        }

    }

    @Override
    public List<Emp> getAll() {

        return empMapper.getAll();
    }

    @Override
    public LoginInfo findByUsernameAndPassword(Emp emp) {

        LoginInfo info = empMapper.findByUsernameAndPassword(emp);

        if (info!=null){
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", info.getId());
            claims.put("username", info.getUsername());

//            1. create jwt
            String jwt = JwtUtils.createToken(claims);

//            2. set token
            info.setToken(jwt);

        }

        return info;
    }

}
