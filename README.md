### Playing around with micronaut data and JSON serialization

Including entity mapping examples such as 121 and one-to-many

GET all activities from http://localhost:8080/api/activities

GET all activities for a given location name from http://localhost:8080/api/activities/allForLocation?location=Melksham campus

POST a new activity to http://localhost:8080/api/activities e.g.

    {
        "name": "Hike",
        "location": {
            "name": "Westbury"
        },
        "equipment": [
            {
                "name": "Hiking boots"
            }
        ],
        "heartRates": [
            {
                "minute": 1,
                "avgHr": 60
            },
            {
                "minute": 2,
                "avgHr": 68
            }
        ]
    }