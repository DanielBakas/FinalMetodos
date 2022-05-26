import FetchService from './services/FetchService.js';
const API = 'http://localhost:8080/mg1';

//const API = 'https://jsonplaceholder.typicode.com/posts';
/**
 * /mg1
 * /mm1
 * /mms
 * /mmsk
 * /md1
 * /me1
 */
const mg1 = "mg1";
const mm1 = "mm1";
const mms = "mms";
const mmsk = "mmsk";
const md1 = "md1";
const me1 = "me1";

let model = document.getElementById('model');
document.getElementById('model').onchange = function() {
    console.log(model.value);
    switch (model.value) {
        case "mg1":
            document.getElementById('MG1').style.display = "block";
            document.getElementById('MMSK').style.display = "none";
            document.getElementById('MM1').style.display = "none";
            document.getElementById('MMS').style.display = "none";
            document.getElementById('ME1').style.display = "none";
            document.getElementById('MD1').style.display = "none";
            break;
        case "mm1":
            document.getElementById('MG1').style.display = "none";
            document.getElementById('MMSK').style.display = "none";
            document.getElementById('MM1').style.display = "block";
            document.getElementById('MMS').style.display = "none";
            document.getElementById('ME1').style.display = "none";
            document.getElementById('MD1').style.display = "none";
            break;
        case "mmsk":
            document.getElementById('MG1').style.display = "none";
            document.getElementById('MMSK').style.display = "block";
            document.getElementById('MM1').style.display = "none";
            document.getElementById('MMS').style.display = "none";
            document.getElementById('ME1').style.display = "none";
            document.getElementById('MD1').style.display = "none";
            break;
        case "mms":
            document.getElementById('MG1').style.display = "none";
            document.getElementById('MMSK').style.display = "none";
            document.getElementById('MM1').style.display = "none";
            document.getElementById('MMS').style.display = "block";
            document.getElementById('ME1').style.display = "none";
            document.getElementById('MD1').style.display = "none";
            break;
        case "md1":
            document.getElementById('MG1').style.display = "none";
            document.getElementById('MMSK').style.display = "none";
            document.getElementById('MM1').style.display = "none";
            document.getElementById('MMS').style.display = "none";
            document.getElementById('ME1').style.display = "none";
            document.getElementById('MD1').style.display = "block";
            break;
        case "me1":
            document.getElementById('MG1').style.display = "none";
            document.getElementById('MMSK').style.display = "none";
            document.getElementById('MM1').style.display = "none";
            document.getElementById('MMS').style.display = "none";
            document.getElementById('ME1').style.display = "block";
            document.getElementById('MD1').style.display = "none";
            break;

        default:
            break;
    }
};

/*-- Objects --*/
const fetchService = new FetchService();

/*--Functions--*/
async function submitForm(e, form) {
    e.preventDefault();
    const btnSubmit = document.getElementById('btnSubmit');
    btnSubmit.disabled = true;
    setTimeout(() => btnSubmit.disabled = false, 2000);
    const jsonFormData = buildJsonFormData(form);
    const headers = buildHeaders();
    const response = await fetchService.performPostHttpRequest(`${API}/${model.value}`, headers, jsonFormData);
    if(response){
        document.getElementById('response').innerHTML = JSON.stringify(response);
        console.log(response);
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

/*--Event Listeners--*/
const sampleForm = document.querySelector("#sampleForm");
if(sampleForm) {
    sampleForm.addEventListener("submit", function(e) {
        submitForm(e, this);
    });
}

