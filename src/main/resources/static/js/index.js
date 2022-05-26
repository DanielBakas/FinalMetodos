import FetchService from './services/FetchService.js';
const API = 'http://localhost:8080';
let model = "";


/*-- Objects --*/
const fetchService = new FetchService();

/*--Functions--*/
async function submitForm(e, form) {
    console.log(form);
    e.preventDefault();
    const btnSubmit = document.getElementById('btnSubmit');
    btnSubmit.disabled = true;
    setTimeout(() => btnSubmit.disabled = false, 2000);
    const jsonFormData = buildJsonFormData(form);
    const headers = buildHeaders();
    const response = await fetchService.performPostHttpRequest(`${API}/${model}`, headers, jsonFormData);
    if(response){
        console.log(JSON.stringify(response));
        mapResponse(response);
    }
    else
        alert(`An error occured.`);
}

function buildHeaders() {
    const headers = {
        "Content-Type": "application/json"
    };
    return headers;
}

function buildJsonFormData(form) {
    const jsonFormData = { };
    for(const pair of new FormData(form)) {
        jsonFormData[pair[0]] = pair[1];
    }
    return jsonFormData;
}

function mapResponse(obj){
    console.log(obj);
    document.getElementById('p0').innerHTML = obj.p0;
    document.getElementById('le').innerHTML = obj.lambdaE;
    document.getElementById('wq').innerHTML = obj.wq;
    document.getElementById('w').innerHTML = obj.w;
    document.getElementById('l').innerHTML = obj.l;
    document.getElementById('lq').innerHTML = obj.lq;
}

/*--Event Listeners--*/
const sampleForm = document.querySelector("#sampleForm");
if(sampleForm) {
    sampleForm.addEventListener("submit", function(e) {
        model = "mmsk";
        submitForm(e, this);
    });
}

const form2 = document.querySelector('#form2');
if(form2) {
    form2.addEventListener("submit", function(e) {
        model = "mm1";
        submitForm(e, this);
    });
}

const form3 = document.querySelector('#form3');
if(form3) {
    form3.addEventListener("submit", function(e) {
        model = "mg1";
        submitForm(e, this);
    });
}
const form4 = document.querySelector('#form4');
if(form4) {
    form4.addEventListener("submit", function(e) {
        model = "mms";
        submitForm(e, this);
    });
}
const form5 = document.querySelector('#form5');
if(form5) {
    form5.addEventListener("submit", function(e) {
        model = "md1";
        submitForm(e, this);
    });
}

const form6 = document.querySelector('#form6');
if(form6) {
    form6.addEventListener("submit", function(e) {
        model = "me1";
        submitForm(e, this);
    });
}
