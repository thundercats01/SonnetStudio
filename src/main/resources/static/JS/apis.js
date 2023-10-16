(() => {

    const checkSpelling = async() => {
        const textToCheck = document.getElementById('textToCheck').value;
        const encodedText = encodeURIComponent(textToCheck);
        const url = `https://webspellchecker-webspellcheckernet.p.rapidapi.com/ssrv.cgi?cmd=check_spelling&user_dictionary=Input_Dictionary_Name&text=${encodedText}&slang=en_US&out_type=words&format=xml`;

        const options = {
            method: 'GET',
            headers: {
                'X-RapidAPI-Key': spellCheckKey,
                'X-RapidAPI-Host': 'webspellchecker-webspellcheckernet.p.rapidapi.com'
            }
        };

        try {
            const response = await fetch(url, options);
            const result = await response.text();
            console.log(result);

            const parser = new DOMParser();
            const xmlDoc = parser.parseFromString(result, "text/xml");
            const errors = xmlDoc.getElementsByTagName("word");

            let output = '';
            if (errors.length > 0) {
                output = '' +
                    '<div class="pb-4"><h5>Spelling Errors:</h5></div><ul>';
                for (let i = 0; i < errors.length; i++) {
                    output += `<li>${errors[i].textContent}</li>`;
                }
                output += '</ul>';
            } else {
                output = '<h5>No spelling errors found.</h5>';
            }

            document.querySelector('#checkSpelling').innerHTML = output;

        } catch (error) {
            console.log(error);
        }
    }


    document.querySelector('#checkSpelling').addEventListener('click', checkSpelling);

    const profanityFilter = async () => {
        const textToCheck = document.getElementById('textToCheck');
        const url = `https://profanity-filter-by-api-ninjas.p.rapidapi.com/v1/profanityfilter?text=${textToCheck.value}`;
        const options = {
            method: 'GET',
            headers: {
                'X-RapidAPI-Key': profanityCheckKey,
                'X-RapidAPI-Host': 'profanity-filter-by-api-ninjas.p.rapidapi.com'
            }
        };

        try {
            const response = await fetch(url, options);
            const result = await response.json(); // Assuming the API returns JSON
            console.log(result.censored);

            // Update the value of the input field
            textToCheck.value = result.censored;

            // Get the form element
            const form = document.getElementById('myForm');

            // Submit the form
            form.submit();
        } catch (error) {
            console.error(error);
        }
    }


    document.querySelector("#createSubmit").addEventListener("click", () => {
        profanityFilter();
    })




})();