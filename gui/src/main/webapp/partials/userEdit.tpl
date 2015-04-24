    <button type="button" class="close" ng-click="cancel();">
        <i class="fa fa-times-circle-o" style="margin:10px;color:blue;"></i>
    </button>
    <div class="modal-header">
        <h3 class="modal-title">Edit user [Username: {{user.userName}}]</h3>
    </div>
    <div class="modal-body">
        <form name="user_form" class="form-horizontal" role="form" novalidate>
            <!-- LDAP -->
            <form-element label="LDAP" mod="user">
                <input type="text" class="form-control" name="ldap" placeholder="LDAP" ng-model="user.userLdap" ng-disabled="user.userName" focus/>
            </form-element>

            <!-- FULL NAME -->
            <!--<form-element label="FULL NAME" mod="user">
                <input type="text" name="userFio" class="form-control" placeholder="FULL NAME" ng-model="user.userFio"/>
            </form-element>-->
            <form-element label="FULL NAME" mod="user">
                <div class="form-group" ng-class="{ 'has-error' : user_form.userFio.$invalid && !user_form.userFio.$pristine }">
                    <input type="text" name="userFio" class="form-control" ng-model="user.userFio" ng-minlength="3" ng-maxlength="40">
                    <p ng-show="user_form.userFio.$error.minlength" class="help-block">userFio is too short.</p>
                    <p ng-show="user_form.userFio.$error.maxlength" class="help-block">userFio is too long.</p>
                </div>
            </form-element>

            <!-- EMAIL -->
            <!--<form-element label="E-MAIL" mod="user">
                <input type="email" name="email" class="form-control" placeholder="E-MAIL" ng-model="user.email"/>
                <small class="errorMessage" ng-show="user_form.email.$dirty && user_form.email.$invalid">Enter the email.</small>
            </form-element>-->
            <form-element label="E-MAIL" mod="user">
                <div class="form-group" ng-class="{ 'has-error' : user_form.email.$invalid && !user_form.email.$pristine }">
                    <input type="email" name="email" class="form-control" ng-model="user.email">
                    <p ng-show="user_form.email.$invalid && !user_form.email.$pristine" class="help-block">Enter a valid email.</p>
                </div>
            </form-element>

            <!-- GROUP -->
            <!--<form-element label="GROUP" mod="user">
                <input type="text" name="groupName" class="form-control" placeholder="GROUP" ng-model="user.groupName"/>
                <small class="errorMessage" ng-show="user_form.groupName.$dirty && user_form.groupName.$invalid">Enter the available groupName.</small>
            </form-element>-->
            <!--[[ http://plnkr.co/edit/isxmRkZ2EHkrxESkxpmO?p=preview ]]-->
            <!--[ https://www.safaribooksonline.com/library/view/angularjs-up-and/9781491901939/ch04.html ]-->
            <!--[ http://gurustop.net/blog/2014/01/28/common-problems-and-solutions-when-using-select-elements-with-angular-js-ng-options-initial-selection/ ]-->
            <!--[ http://www.undefinednull.com/2014/08/11/a-brief-walk-through-of-the-ng-options-in-angularjs/ ]-->
            <!--[ http://stackoverflow.com/questions/18202106/angular-js-ng-options-with-simple-array-init ]-->
            <form-element label="GROUP" mod="user">
                <!--<select class="form-control" groupName="symbol" ng-model="user.symbol" ng-options="symbol.name group by symbol.shade disable when symbol.notAnOption for symbol in VALID_SYMBOLS">-->
                <!--<select  class="form-control" ng-init="user.groupName=5" name="groupName" ng-model="user.groupName"  ng-options="group.value as group.text group by group.type for group in groups">-->
                <select class="form-control"
                        name="groupName"
                        ng-model="user.groupName"
                        ng-init="user.groupName = {value: groupSelect}"
                        ng-change="select.groupValue = user.groupName.value"
                        ng-options="group.text group by group.type for group in groups track by group.value">
                    <option value="">-- undefined --</option>
                </select>
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

