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

 <ul class="nav nav-pills d-inline-flex justify-content-center border-bottom mb-5">
                        <li class="nav-item">
                            <a class="d-flex align-items-center text-start mx-3 ms-0 pb-3 active" data-bs-toggle="pill" href="#tab-1">
                                <h6 class="mt-n1 mb-0">Featured</h6>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="d-flex align-items-center text-start mx-3 pb-3" data-bs-toggle="pill" href="#tab-2">
                                <h6 class="mt-n1 mb-0">Full Time</h6>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="d-flex align-items-center text-start mx-3 me-0 pb-3" data-bs-toggle="pill" href="#tab-3">
                                <h6 class="mt-n1 mb-0">Part Time</h6>
                            </a>
                        </li>
                    </ul>