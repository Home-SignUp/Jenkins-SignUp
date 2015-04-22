    <button type="button" class="close" ng-click="cancel();">
        <i class="fa fa-times-circle-o" style="margin:10px;color:blue;"></i>
    </button>
    <div class="modal-header">
        <h3 class="modal-title">Edit user [Username: {{user.userName}}]</h3>
    </div>
    <div class="modal-body">
        <form name="user_form" class="form-horizontal" role="form" novalidate>
            <form-element label="LDAP" mod="user">
                <input type="text" class="form-control" name="ldap" placeholder="LDAP" ng-model="user.userLdap" ng-disabled="user.userName" focus/>
            </form-element>
            <form-element label="FULL NAME" mod="user">
                <textarea class="form-control" name="userFio" placeholder="FULL NAME" ng-model="user.userFio">{{user.userFio}}</textarea>
            </form-element>
            <form-element label="E-MAIL" mod="user">
                <input type="text" name="email" class="form-control" placeholder="E-MAIL" ng-model="user.email"  only-numbers/>
                <small class="errorMessage" ng-show="user_form.email.$dirty && user_form.email.$invalid"> Enter the email.</small>
            </form-element>
           <form-element label="GROUP" mod="user">
                <input type="text" name="groupName" class="form-control" placeholder="GROUP" ng-model="user.groupName" only-numbers/>
                <small class="errorMessage" ng-show="user_form.groupName.$dirty && user_form.groupName.$invalid"> Enter the available groupName.</small>
            </form-element>
            <div class="space"></div>
            <div class="space-4"></div>
            <div class="modal-footer">
                <form-element label="">
                    <div class="text-right">
                        <a class="btn btn-sm" ng-click="cancel()"><i class="ace-icon fa fa-reply"></i>Cancel</a>
                        <button ng-click="saveUser(user);"
                                ng-disabled="user_form.$invalid || enableUpdate"
                                class="btn btn-sm btn-primary"
                                type="submit">
                            <i class="ace-icon fa fa-check"></i>{{buttonText}}
                        </button>
                    </div>
                </form-element>
            </div>
        </form>
    </div>

