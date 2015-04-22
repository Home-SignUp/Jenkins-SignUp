<div ng-controller="RegisterCtrl as register">
    <form class="form-horizontal" role="form" ng-submit="register.createUser()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Create a new user:</label>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">USERNAME</label>
            <div class="col-sm-4">
                <input class="form-control" id="userName" placeholder="USERNAME" ng-model="register.userName" ng-required="true">
                <!--<span ng-show="register.nameRequired">{{register.nameRequired}}</span>-->
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">USERPASS</label>
            <div class="col-sm-4">
                <input class="form-control" id="userPass" placeholder="USERPASS" ng-model="register.userPass">
                <span ng-show="register.passRequired">{{register.passRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">USERLDAP</label>
            <div class="col-sm-4">
                <input class="form-control" id="userLdap" placeholder="USERLDAP" ng-model="register.userLdap">
                <span ng-show="register.ldapRequired">{{register.ldapRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="stock" class="col-sm-2 control-label">USERFIO</label>
            <div class="col-sm-4">
                <input class="form-control" id="userFio" placeholder="USERFIO" ng-model="register.userFio">
                <span ng-show="register.fioRequired">{{register.fioRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="packing" class="col-sm-2 control-label">E-MAIL</label>
            <div class="col-sm-4">
                <input class="form-control" id="email" placeholder="E-MAIL" ng-model="register.email">
                <span ng-show="register.emailRequired">{{register.emailRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="stock" class="col-sm-2 control-label">GROUPNAME</label>
            <div class="col-sm-4">
                <input class="form-control" id="groupName" placeholder="GROUPNAME" ng-model="register.groupName">
                <span ng-show="register.groupRequired">{{register.groupRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-success" />
            </div>
        </div>

        <p ng-show="register.newUserName">
            User created with userName: {{register.newUserName}}
        </p>
    </form>
</div>
