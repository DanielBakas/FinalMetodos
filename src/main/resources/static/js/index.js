import FetchService from './services/FetchService.js';
const API = 'http://localhost:8080/mg1';
//const API = 'https://jsonplaceholder.typicode.com/posts';
/**
 * /mg1
 * /mm1
 * /mms
 * /mmsk
 */

/*
const htmlResponse = document.querySelector("#response");
const tpl = document.createDocumentFragment();

fetch('${API}/mm1')
.then(response => console.log(response.json()));  
*/


/*-- Objects --*/
const fetchService = new FetchService();

/*--Functions--*/
async function submitForm(e, form) {
    // 1. Prevent reloading page
    e.preventDefault();
    // 2. Submit the form
    // 2.1 User Interaction
    const btnSubmit = document.getElementById('btnSubmit');
    btnSubmit.disabled = true;
    setTimeout(() => btnSubmit.disabled = false, 2000);
    // 2.2 Build JSON body
    const jsonFormData = buildJsonFormData(form);
    // 2.3 Build Headers
    const headers = buildHeaders();
    // 2.4 Request & Response
    const response = await fetchService.performPostHttpRequest(`${API}`, headers, jsonFormData); // Uses JSON Placeholder
    console.log('Response: '+ response);
    // 2.5 Inform user of result
    if(response){
        //window.location = `/success.html?FirstName=${response.FirstName}&LastName=${response.LastName}&Email=${response.Email}&id=${response.id}`;
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
/*--/Functions--*/

/*--Event Listeners--*/
const sampleForm = document.querySelector("#sampleForm");
if(sampleForm) {
    sampleForm.addEventListener("submit", function(e) {
        submitForm(e, this);
    });
}

