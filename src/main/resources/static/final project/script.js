const apiUrl = 'http://localhost:8080/api/country';

// Save a new country
function saveCountry() {
    const countryName = document.getElementById('countryName').value;
    const population = document.getElementById('population').value;

    if (countryName.trim() && population.trim()) {
        fetch(`${apiUrl}/save`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ country_name: countryName, population: parseInt(population) })
        })
            .then(response => response.json())
            .then(data => {
                alert('Country saved with ID: ' + data);
                document.getElementById('countryName').value = '';
                document.getElementById('population').value = '';
            })
            .catch(error => console.error('Error:', error));
    } else {
        alert('Please enter a country name and population');
    }
}
function listCountries() {
    fetch(`${apiUrl}/list`)
        .then(response => response.json())
        .then(data => {
            const countryList = document.getElementById('countryList');
            countryList.innerHTML = ''; // Clear existing list
            data.forEach(country => {
                const li = document.createElement('li');
                li.textContent = `${country.id}: ${country.country_name} (Population: ${country.population})`;
                countryList.appendChild(li);
            });
        })
        .catch(error => console.error('Error:', error));
}

// Delete a country by ID
function deleteCountry() {
    const id = document.getElementById('countryId').value;

    if (id.trim()) {
        fetch(`${apiUrl}/${id}`, { // Correct usage of template literals to include the ID
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    alert('Country deleted successfully');
                    document.getElementById('countryId').value = '';
                } else {
                    alert('Failed to delete country. Please check the ID.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error deleting country');
            });
    } else {
        alert('Please enter a valid Country ID');
    }
}
const cityApiUrl = 'http://localhost:8080/api/city';

// Save a new city
function saveCity() {
    const cityName = document.getElementById('cityName').value;
    const cityPopulation = document.getElementById('cityPopulation').value;
    const crimeRate = document.getElementById('crimeRate').value;
    const countryId = document.getElementById('countryId').value;
    const categoryId = document.getElementById('categoryId').value;

    if (cityName.trim() && cityPopulation.trim() && countryId.trim() && categoryId.trim()) {
        const cityData = {
            city_name: cityName,
            city_population: parseInt(cityPopulation),
            crime_rate: parseFloat(crimeRate),
            country: { id: parseInt(countryId) },
            category: { id: parseInt(categoryId) }
        };

        fetch(`${cityApiUrl}/save`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(cityData)
        })
            .then(response => response.json())
            .then(data => {
                alert('City saved with ID: ' + data);
                document.getElementById('cityName').value = '';
                document.getElementById('cityPopulation').value = '';
                document.getElementById('crimeRate').value = '';
                document.getElementById('countryId').value = '';
                document.getElementById('categoryId').value = '';
            })
            .catch(error => console.error('Error:', error));
    } else {
        alert('Please enter all required fields');
    }
}

// Delete a city by ID
function deleteCity() {
    const id = document.getElementById('cityId').value;

    if (id.trim()) {
        fetch(`${cityApiUrl}/${id}`, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    alert('City deleted successfully');
                    document.getElementById('cityId').value = '';
                } else {
                    alert('Failed to delete city. Please check the ID.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error deleting city');
            });
    } else {
        alert('Please enter a valid City ID');
    }
}

