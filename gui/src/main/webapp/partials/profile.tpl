<!--<h1>Hi <b>{{vm.user.firstName}}</b>!</h1>-->
<h1>Hi <b>{{vm.user.userFio}}</b>!</h1>
<p><font color=#006400>You're logged In.</font></p>
<h3>All registered users:</h3>
<ul>
    <li ng-repeat="user in vm.allUsers">
        <!--{{user.username}} ({{user.lastName}} {{user.firstName}}) ... <b>[</b><font color=red> <a href="#" ng-click="vm.deleteUser(user.id)">Delete</a> </font><b>]</b>-->
        {{user.userName}} ({{user.userFio}}) ... <b>[</b><font color=red> <a href="#" ng-click="vm.deleteUser(user.id)">Delete</a> </font><b>]</b>
    </li>
</ul>