
//the original number(this is text from the html), it keeps updating as the number keys are pressed
let oNum;

//adds all the tax from all items marked with 'tax'
//database field
let totalTax = 0;

//this is the price of the current 'oNum' in a 'Number' object form
let itemPrice = 0;

//list of prices in the cart
let allItemsPrices = new Array();

//database field
let listTotalPrice = 0;

//checks to see if the subtotal button is pressed for 'oNum' to clear the screen appropriately
let pressedSub = false;

function typeNumbers(newNum) {
    if(pressedSub == true) {
        clearScreen();
        pressedSub = false;
    }

    //getting the current number inside the p tag into a string
    oNum = document.getElementById('number').innerHTML;
    console.log(oNum);

    //adding the newly typed number into the current number
    oNum += newNum;
    console.log(oNum);

    itemPrice = Number(oNum);


    //insert newly typed number into screen
    let newElementNum = document.createTextNode(oNum);
    document.getElementById('number').innerText = oNum;

}

//=================Non Tax Button
document.getElementById("noTax").onclick = function() {
    calcNonTax();
};

function calcNonTax() {

    //get the item-display id in order to insert the new item
    let newLine = document.createElement('li')
    let newItem = document.createTextNode("$" + itemPrice + " Non Tax");
    newLine.appendChild(newItem);

    let listSection = document.getElementById('item-list');
    listSection.appendChild(newLine);

    allItemsPrices.push(itemPrice);

    clearScreen();
    oNum = 0;
    itemPrice = 0;
}

//=================Tax Button
document.getElementById("tax").onclick = function() {
    calcTax();
};

function calcTax() {

    //calculate item with tax
    let itemTax = Math.round((itemPrice * .05) * 100) / 100;
    console.log(itemTax);

    //retrieve the itemTax to the totalTax
    totalTax += itemTax;

    //add tax to the entered number
    //itemPrice += itemTax;
    //console.log(itemPrice);

    //get the item-display id in order to insert the new item
    let newLine = document.createElement('li')
    let newItem = document.createTextNode("$" + itemPrice + " Tax");
    newLine.appendChild(newItem);

    let listSection = document.getElementById('item-list');
    listSection.appendChild(newLine);

    //add tax to the entered number
    itemPrice += itemTax;
    console.log(itemPrice);

    //add the item price with its tax to the list of prices in the cart
    allItemsPrices.push(itemPrice);

    clearScreen();
    oNum = 0;
    itemPrice = 0;
}

//=================Subtotal Button
document.getElementById("sub").onclick = function() {
    pressedSub = true;
    calcSubtotal();
};

function calcSubtotal() {

    listTotalPrice = 0;
    //get the listTotalPrice
    for (let i = 0; i < allItemsPrices.length; i++) {
        listTotalPrice += allItemsPrices[i];
    }

    //empty the screen if there is anything on the screen
    clearScreen();

    //get the total of all items (including their given tax) and append it to the document
    let totalLine = document.getElementById("number");
    let totalPrice = document.createTextNode("Total: $" + listTotalPrice);
    totalLine.appendChild(totalPrice);

}

//=================Cash Button
document.getElementById("cash").onclick = function() {
    calcCash();
};

function calcCash() {
    //empty the screen if there is anything on the screen
    //clearScreen();

    //subtracting the cash to the listTotalPrice
    //database field
    let cash = itemPrice;
    //database field
    let changeDue = 0
    changeDue = Math.round((cash - listTotalPrice) * 100) / 100;

    //get the change due and append it to the document
    clearScreen();
    let changeDueLine = document.getElementById("number");
    let totalPrice = document.createTextNode("Change Due: $" + changeDue);
    changeDueLine.appendChild(totalPrice);

    //print the subtotal, amount due, and change due on the item display
    let listSection = document.getElementById('item-list');

    let blankLine = document.createElement('li');
    listSection.appendChild(blankLine);

    let taxLine = document.createElement('li');
    let taxItem = document.createTextNode("Tax: $" + totalTax);
    taxLine.appendChild(taxItem);
    listSection.appendChild(taxLine);

    let totalLine = document.createElement('li');
    let totalItem = document.createTextNode("Total: $" + listTotalPrice);
    totalLine.appendChild(totalItem);
    listSection.appendChild(totalLine);

    let cashLine = document.createElement('li');
    let cashItem = document.createTextNode("Cash: $" + cash);
    cashLine.appendChild(cashItem);
    listSection.appendChild(cashLine);

    let changeLine = document.createElement('li');
    let changeItem = document.createTextNode("Change Due: $" + changeDue);
    changeLine.appendChild(changeItem);
    listSection.appendChild(changeLine);

    //send to database
    alert("Purchase has been recorded");
}


//=================Item-list Button

//=================Void Button

//=================Clear Button
document.getElementById("clr").onclick = function() {
    clearScreen();
};

function clearScreen() {
    oNum = "";
    document.getElementById('number').innerText = oNum;
}
