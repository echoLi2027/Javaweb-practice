import { printLog } from "./utils.js";
//click: mouse click event
document.querySelector('#b2').addEventListener('click', () => {
    printLog();
})

//mouseenter: mouse enters
document.querySelector('#last').addEventListener('mouseenter', () => {
    console.log("Mouse entered...");
})

//mouseleave: mouse leaves
document.querySelector('#last').addEventListener('mouseleave', () => {
    console.log("Mouse left...");
})

//keydown: keyboard key is pressed down
document.querySelector('#username').addEventListener('keydown', () => {
    console.log("Key was pressed down...");
})

//keyup: keyboard key is released
document.querySelector('#username').addEventListener('keyup', () => {
    console.log("Key was released...");
})

//blur: lost focus event
document.querySelector('#age').addEventListener('blur', () => {
    console.log("Lost focus...");
})

//focus: element gains focus
document.querySelector('#age').addEventListener('focus', () => {
    console.log("Gained focus...");
})

//input: triggered when user inputs
document.querySelector('#age').addEventListener('input', () => {
    console.log("Triggered when user inputs...");
})

//submit: form submission event
document.querySelector('form').addEventListener('submit', () => {
    alert("Form was submitted...");
})