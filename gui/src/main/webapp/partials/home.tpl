<div ng-controller="HomeCtrl as home">
    <form class="form-horizontal" role="form" ng-submit="home.createPerson()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Create a new user:</label>
        </div>
        <div class="form-group">
            <label for="userName" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-4">
                <input class="form-control" id="userName" placeholder="Name" ng-model="home.userName" ng-required="true">
                <!--<span ng-show="userRequired">{{userRequired}}</span>-->
            </div>
        </div>
        <div class="form-group">
            <label for="firstName" class="col-sm-2 control-label">First Name</label>
            <div class="col-sm-4">
                <input class="form-control" id="firstName" placeholder="First Name" ng-model="home.firstName">
                <span ng-show="home.firstRequired">{{home.firstRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="lastName" class="col-sm-2 control-label">First Name</label>
            <div class="col-sm-4">
                <input class="form-control" id="lastName" placeholder="First Name" ng-model="home.lastName">
                <span ng-show="home.lastRequired">{{home.lastRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-success" />
            </div>
        </div>

        <p ng-show="home.newUserId">
            User created with id: {{home.newUserId}}
        </p>
    </form>

    <hr />

    <div>
        <form class="form-horizontal" role="form" ng-submit="home.searchPerson()">
            <div class="form-group">
                <label class="col-sm-2 control-label">Find a user:</label>
            </div>
            <div class="form-group">
                <label for="searchPersonId" class="col-sm-2 control-label">by Id</label>
                <div class="col-sm-4">
                    <input class="form-control" id="searchPersonId" placeholder="Id" ng-model="home.searchPersonId" ng-required="true" />
                </div>
            </div>
        </form>

        <div class="searchOutput">{{home.person | json}}</div>
    </div>
</div>
