<div ng-controller="SignupCtrl as signup">
    <form class="form-horizontal" role="form" ng-submit="signup.createPerson()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Create a new user:</label>
        </div>
        <div class="form-group">
            <label for="userName" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-4">
                <input class="form-control" id="userName" placeholder="Name" ng-model="signup.userName" ng-required="true">
                <!--<span ng-show="userRequired">{{userRequired}}</span>-->
            </div>
        </div>
        <div class="form-group">
            <label for="firstName" class="col-sm-2 control-label">First Name</label>
            <div class="col-sm-4">
                <input class="form-control" id="firstName" placeholder="First Name" ng-model="signup.firstName">
                <span ng-show="signup.firstRequired">{{signup.firstRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="lastName" class="col-sm-2 control-label">Last Name</label>
            <div class="col-sm-4">
                <input class="form-control" id="lastName" placeholder="Last Name" ng-model="signup.lastName">
                <span ng-show="signup.lastRequired">{{signup.lastRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-success" />
            </div>
        </div>

        <p ng-show="signup.newUserId">
            User created with id: {{signup.newUserId}}
        </p>
    </form>

    <hr />

    <div>
        <form class="form-horizontal" role="form" ng-submit="signup.searchPerson()">
            <div class="form-group">
                <label class="col-sm-2 control-label">Find a user:</label>
            </div>
            <div class="form-group">
                <label for="searchPersonId" class="col-sm-2 control-label">by Id</label>
                <div class="col-sm-4">
                    <input class="form-control" id="searchPersonId" placeholder="Id" ng-model="signup.searchPersonId" ng-required="true" />
                </div>
            </div>
        </form>

        <div class="searchOutput">{{signup.person | json}}</div>
    </div>
</div>
