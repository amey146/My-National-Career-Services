<!-- Search Start -->
<div class="container-fluid bg-primary mb-5 wow fadeIn" data-wow-delay="0.1s" style="padding: 35px;">
    <div class="container">
        <div class="row g-2">
            <div class="col-md-10">
                <div class="row g-2">
                    <div class="col-md-4">
                        <input type="text" class="form-control border-0" placeholder="Keyword" />
                    </div>
                    <div class="col-md-4">
                        <select class="form-select border-0">
                            <option selected>Category</option>
                            <option value="1">Category 1</option>
                            <option value="2">Category 2</option>
                            <option value="3">Category 3</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <select class="form-select border-0">
                            <option selected>Location</option>
                            <option value="1">Location 1</option>
                            <option value="2">Location 2</option>
                            <option value="3">Location 3</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-md-2">
                <button class="btn btn-dark border-0 w-100">Search</button>
            </div>
        </div>
    </div>
</div>
<!-- Search End -->


<div>
    <input class="form-control" type="text" name="" id="" placeholder="ex: Java; Data Entry; Accounts; Sales etc">
    <p class="form-text">
        Use ; to search for multiple keywords
    </p>
</div>
<div class="form-check">
    <input class="form-check-input" type="radio" name="location" id="allIndia" onclick="toggleDropdown(false)">
    <label class="form-check-label" for="allIndia">All India</label>
</div>
<div class="form-check">
    <input class="form-check-input" type="radio" name="location" id="selectLocation" onclick="toggleDropdown(true)">
    <label class="form-check-label" for="selectLocation">Select Location</label>

</div>
<label class="form-label" for="cities">Choose a state:</label>
<select class="form-select" aria-label="Default select example">
    <option value="Delhi">Delhi</option>
    <option value="Lakshadweep">Lakshadweep</option>
    <option value="Puducherry">Puducherry</option>
</select>

<label class="col-sm-2 col-form-label" for="org">Organisation Type</label>
<div class="col-sm-10">
    <select name="" id="org" class="form-select" aria-label="Default select example">
        <option value="all">All Jobs</option>
        <option value="private">Private Sector</option>
        <option value="government">Government Sector</option>
    </select>
</div>
<label class="col-sm-2 col-form-label" for="sector">Sector</label>
<div class="col-sm-10">
    <select size="4" multiple="multiple" name="sector" class="form-select" multiple
        aria-label="multiple select example">
        <option value="10">Hotels, Food Service and Catering</option>
        <option value="21">International Organizations</option>
        <option value="20">Household and Domestic Work</option>
        <option value="15">Operations and Support</option>
        <option value="2">Agriculture and Related</option>
    </select>
    <p class="form-text">
        Use CRTL + mouse click to multi-select options
    </p>
</div>

<label class="col-sm-2 col-form-label" for="functionalarea">Functional
    Area</label>
<div class="col-sm-10">
    <select name="functionalarea" class="form-select" aria-label="Default select example">
        <option value="4">Administration/Back Office Activities</option>
        <option value="9">Analytics &amp; Business Intelligence</option>
        <option value="8">Customer Care Service</option>
    </select>
</div>
<label class="col-sm-2 col-form-label" for="exp">Total Work Experience (years)</label>
<div class="col-sm-10">
    <select name="exp" id="expSelect" class="form-select" aria-label="Default select example">
        <!-- Options will be added dynamically using JavaScript -->
    </select>
</div>

<!-- Page Specific -->

<style>
    #cityDropdown {
        display: none;
    }
</style>
<script>
    function toggleDropdown(showDropdown) {
        var dropdown = document.getElementById("cityDropdown");
        dropdown.style.display = showDropdown ? "block" : "none";
    }
</script>

//For Keywords 
String[] keywords = request.getParameter("keywords").split(";");
StringBuilder keywordClause = new StringBuilder("(");
for (int i = 0; i < keywords.length; i++) {
    String keyword = keywords[i].trim();
    keywordClause.append("keywords LIKE '%").append(keyword).append("%'");
    if (i < keywords.length - 1) {
        keywordClause.append(" OR ");
    }
}
keywordClause.append(")");

String finalQuery = "SELECT * FROM jobs_table WHERE ... AND " + keywordClause.toString();

...{
SELECT * FROM jobs_table
WHERE (location = 'allIndia' OR location = 'selectedState')
AND organisation_type = 'selectedOrgType'
AND sector IN (selectedSector1, selectedSector2, ...)
AND functional_area = 'selectedFunctionalArea'
AND experience = 'selectedExperience'
}