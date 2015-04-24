<div ng-controller="RegisterCtrl as register">
    <form name="register_form" class="form-horizontal" role="form" ng-submit="register.createUser()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Create a new user:</label>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">USERNAME</label>
            <div class="col-sm-4" ng-class="{ 'has-error' : register_form.userName.$invalid && !register_form.userName.$pristine }">
                <!--<input class="form-control" id="userName" placeholder="USERNAME" ng-model="register.userName" ng-required="true">-->
                <!--<span ng-show="register.nameRequired">{{register.nameRequired}}</span>-->
                    <input type="text" name="userName" placeholder="USERNAME" class="form-control" ng-model="register.userName" ng-minlength="3" ng-maxlength="13">
                    <p ng-show="register_form.userName.$error.minlength" class="help-block">userName is too short.</p>
                    <p ng-show="register_form.userName.$error.maxlength" class="help-block">userName is too long.</p>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">USERPASS</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="userPass" placeholder="USERPASS" ng-model="register.userPass">
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
            <div class="col-sm-4" ng-class="{ 'has-error' : register_form.userFio.$invalid && !register_form.userFio.$pristine }">
                <!--<input class="form-control" id="userFio" placeholder="USERFIO" ng-model="register.userFio">
                <span ng-show="register.fioRequired">{{register.fioRequired}}</span>-->
                <input type="text" name="userFio" placeholder="USERFIO" class="form-control" ng-model="register.userFio" ng-minlength="3" ng-maxlength="40">
                <p ng-show="register_form.userFio.$error.minlength" class="help-block">userFio is too short.</p>
                <p ng-show="register_form.userFio.$error.maxlength" class="help-block">userFio is too long.</p>
            </div>
        </div>
        <div class="form-group">
            <label for="packing" class="col-sm-2 control-label">E-MAIL</label>
            <div class="col-sm-4" ng-class="{ 'has-error' : register_form.email.$invalid && !register_form.email.$pristine }">
                <!--<input class="form-control" id="email" placeholder="E-MAIL" ng-model="register.email">-->
                <input type="email" name="email" placeholder="E-MAIL" class="form-control" ng-model="register.email">
                <p ng-show="register_form.email.$invalid && !register_form.email.$pristine" class="help-block">Enter a valid email.</p>
                <span ng-show="register.emailRequired">{{register.emailRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="stock" class="col-sm-2 control-label">GROUPNAME</label>
            <div class="col-sm-4">
                <!--<input class="form-control" id="groupName" placeholder="GROUPNAME" ng-model="register.groupName">
                <span ng-show="register.groupRequired">{{register.groupRequired}}</span>-->
                <select class="form-control"
                        name="groupName"
                        ng-model="register.groupName"
                        ng-options="group.text group by group.type for group in groups track by group.value">
                    <option value="">-- undefined --</option>
                </select>
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