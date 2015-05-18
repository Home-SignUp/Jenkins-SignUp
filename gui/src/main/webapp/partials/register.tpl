<div ng-controller="RegisterCtrl as register" class="col-md-12 col-md-offset-2 jumbotron">
    <form name="register_form" class="form-horizontal" role="form" ng-submit="register.createUser()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Create a new user:</label>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">USERNAME</label>
            <div class="col-sm-4" ng-class="{ 'has-error' : register_form.userName.$invalid && !register_form.userName.$pristine }">
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
                <input type="text" name="userFio" placeholder="USERFIO" class="form-control" ng-model="register.userFio" ng-minlength="3" ng-maxlength="40">
                <p ng-show="register_form.userFio.$error.minlength" class="help-block">userFio is too short.</p>
                <p ng-show="register_form.userFio.$error.maxlength" class="help-block">userFio is too long.</p>
            </div>
        </div>
        <div class="form-group">
            <label for="packing" class="col-sm-2 control-label">E-MAIL</label>
            <div class="col-sm-4" ng-class="{ 'has-error' : register_form.email.$invalid && !register_form.email.$pristine }">
                <input type="email" name="email" placeholder="E-MAIL" class="form-control" ng-model="register.email">
                <p ng-show="register_form.email.$invalid && !register_form.email.$pristine" class="help-block">Enter a valid email.</p>
                <span ng-show="register.emailRequired">{{register.emailRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="stock" class="col-sm-2 control-label">GROUPNAME</label>
            <div class="col-sm-4">
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
                <a href="#/login" class="btn btn-link">Cancel</a>
            </div>
        </div>
        <!--
        <div class="form-actions">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" ng-disabled="form.$invalid || register.dataLoading" class="btn btn-primary">Register</button>
                <img ng-if="register.dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
                <a href="#/login" class="btn btn-link">Cancel</a>
            </div>
        </div>
        -->

        <p ng-show="register.newUserName">
            User created with userName: {{register.newUserName}}
        </p>
    </form>
</div>