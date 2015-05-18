﻿<!--<div class="col-md-6 col-md-offset-3 jumbotron">-->
<div class="col-md-10 col-md-offset-3 jumbotron">

    <div ng-show="vm.error" class="alert alert-danger">{{vm.error}}</div>

    <form name="form" ng-submit="vm.login()" class="form-horizontal" role="form">
        <div class="form-group">
            <label class="col-sm-2 control-label">Login:</label>
        </div>
        <div class="form-group" ng-class="{ 'has-error': form.username.$dirty && form.username.$error.required }">
            <label for="name" class="col-sm-2 control-label">USERNAME</label>
            <div class="col-sm-4">
                <input type="text" name="username" id="username" placeholder="USERNAME" class="form-control" ng-model="vm.username" required />
                <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
            </div>
        </div>
        <div class="form-group" ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required }">
            <label for="name" class="col-sm-2 control-label">USERPASS</label>
            <div class="col-sm-4">
                <input type="password" name="password" id="password" placeholder="USERPASS" class="form-control" ng-model="vm.password" required />
                <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
            </div>
        </div>
        <div class="form-actions">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" ng-disabled="form.$invalid || vm.dataLoading" class="btn btn-primary">Login</button>
                <img ng-if="vm.dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
                <a href="#/register" class="btn btn-link">Register</a>
            </div>
        </div>
    </form>
</div>