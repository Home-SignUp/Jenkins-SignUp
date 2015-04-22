    <hr/>
    <button type="button" class="btn btn-danger fa fa-plus" ng-click="open(user);">&nbsp;Add New User</button>

    <div class="table-responsive">
        <div class="panel panel-primary">
          <div class="panel-heading">
              List of users
              <div class="col-md-2" id="col-md-2">
                  PageSize:
                  <select ng-model="entryLimit" class="nav-search" style="color:black">
                      <option>5</option>
                      <option>10</option>
                      <option>20</option>
                      <option>50</option>
                      <option>100</option>
                  </select>
              </div>
              <div class="sw-search" >
                    <div class="nav-search" id="nav-search">
                        Filter:
                        <span class="input-icon">
                            <input placeholder="Filter users list ..." class="nav-search-input" ng-model="search" ng-change="filter()" autocomplete="off" type="text" style="width:300px;" focus>
                            <i class="search-icon fa fa-search nav-search-icon"></i>
                        </span>
                        Filtered {{filtered.length}} of {{totalItems}} total users
                    </div>
                </div>
            </div>
          <div class="panel-body">
            <table class="table table-striped">
                <tr ng-show="users.length==0"><td style="vertical-align:middle;"><i class="fa fa-ban fa-3x"></i>&nbsp;No data found</td></tr>
                <tr ng-hide="users.length>-1"><td style="vertical-align:middle;"><i class="fa fa-cog fa-3x fa-spin"></i>&nbsp;Loading</td></tr>
                <tr>
                    <th>IP Register&nbsp;<a ng-click="sort_by('ip');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Date Register&nbsp;<a ng-click="sort_by('regdate');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Username&nbsp;<a ng-click="sort_by('userName');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Full Name&nbsp;<a ng-click="sort_by('userFio');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>LDAP&nbsp;<a ng-click="sort_by('userLdap');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>E-mail&nbsp;<a ng-click="sort_by('email');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Group&nbsp;<a ng-click="sort_by('groupName');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>IP Update&nbsp;<a ng-click="sort_by('updateIp');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Date Update&nbsp;<a ng-click="sort_by('updateRegdate');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Status&nbsp;<a ng-click="sort_by('status');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Action</th>
                </tr>
                <tr ng-repeat="data in filtered = (users | filter:search | orderBy : predicate :reverse) | startFrom:(currentPage-1) * entryLimit | limitTo:entryLimit" animate-on-change='data.userName + data.userFio + data.userLdap + data.email + data.groupName + data.ip' ng-animate=" 'animate'">
                    <td>{{data.ip}}</td>
                    <td>{{data.regdate}}</td>
                    <td>{{data.userName}}</td>
                    <td>{{data.userFio}}</td>
                    <td>{{data.userLdap}}</td>
                    <td>{{data.email}}</td>
                    <td>{{data.groupName}}</td>
                    <td>{{data.updateIp}}</td>
                    <td>{{data.updateRegdate}}</td>
                    <td>
                        <button class="btn" ng-class="{Active:'btn-success', Inactive:''}[data.status]" ng-click="changeUserStatus(data);">{{data.status}}</button>
                    </td>
                    <td style="width:100px">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default fa fa-edit" ng-click="open(data);"></button>
                            <button type="button" class="btn btn-danger fa fa-trash-o" ng-click="deleteUser(data);"></button>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
            <div class="col-md-12" ng-show="filteredItems == 0">
                <div class="col-md-12">
                    <h4>No customers found</h4>
                </div>
            </div>
            <div class="col-md-12" ng-show="filteredItems > 0">
                <div pagination="" page="currentPage" on-select-page="setPage(page)" boundary-links="true" total-items="filteredItems" items-per-page="entryLimit" class="pagination-small" previous-text="&laquo;" next-text="&raquo;"></div>
            </div>
        </div>
    </div>