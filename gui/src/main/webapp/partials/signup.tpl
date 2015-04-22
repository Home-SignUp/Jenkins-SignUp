<div ng-controller="SignupCtrl as signup">
    <form class="form-horizontal" role="form" ng-submit="signup.createProduct()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Signup user:</label>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">USERNAME</label>
            <div class="col-sm-4">
                <input class="form-control" id="userName" placeholder="USERNAME" ng-model="signup.userName" ng-required="true">
                <!--<span ng-show="signup.nameRequired">{{signup.nameRequired}}</span>-->
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-success" />
            </div>
        </div>

        <p ng-show="signup.newUserName">
            User created with userName: {{signup.newUserName}}
        </p>
    </form>

    <hr />

    <div>
        <form class="form-horizontal" role="form" ng-submit="signup.searchUser()">
            <div class="form-group">
                <label class="col-sm-2 control-label">Check a user by:</label>
            </div>
            <div class="form-group">
                <label for="searchUserName" class="col-sm-2 control-label">USERNAME</label>
                <div class="col-sm-4">
                    <input class="form-control" id="searchUserName" placeholder="USERNAME" ng-model="signup.searchUserName" ng-required="true" />
                </div>
            </div>
        </form>

        <div class="searchOutput">{{signup.user | json}}</div>
    </div>
</div>
