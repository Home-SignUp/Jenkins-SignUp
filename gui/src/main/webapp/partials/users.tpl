<div ng-controller="UsersCtrl as users">
    <hr/>
    <button type="button" class="btn btn-danger fa fa-plus" ng-click="open(product);">&nbsp;Add New User</button>

    <div class="table-responsive">
        <div class="panel panel-primary">
          <div class="panel-heading">List of users
              <div class="sw-search" >
                  <div class="col-md-2" id="col-md-2">
                      PageSize: <select ng-model="users.entryLimit" class="form-control">
                          <option>5</option>
                          <option>10</option>
                          <option>20</option>
                          <option>50</option>
                          <option>100</option>
                      </select>
                  </div>
                    <div class="nav-search" id="nav-search">
                        Filter: <span class="input-icon">
                            <input placeholder="Filter products list ..." class="nav-search-input" ng-model="users.filterProduct" ng-change="users.resetLimit();"  autocomplete="off" type="text" style="width:300px;" focus>
                            <i class="search-icon fa fa-search nav-search-icon"></i>
                        </span>
                    </div>
                </div>
            </div>
          <div class="panel-body">
            <table class="table table-striped">
            <tr ng-show="products.length==0"><td style="vertical-align:middle;"><i class="fa fa-ban fa-3x"></i>&nbsp;No data found</td></tr>
            <tr ng-hide="products.length>-1"><td style="vertical-align:middle;"><i class="fa fa-cog fa-3x fa-spin"></i>&nbsp;Loading</td></tr>

            <tr><th ng-repeat="c in columns">{{c.text}}</th></tr>



            <!--<tr ng-repeat="c in products | filter:filterProduct | orderBy:'-id'" id="{{c.id}}" animate-on-change='c.packing + c.stock + c.price + c.description' ng-animate=" 'animate'">
                <td>{{c.id}}</td><td>{{c.name}}</td><td>{{c.price}}</td><td>{{c.stock}}</td><td>{{c.packing}}</td><td>{{c.description}}</td>
                <td>
                    <button class="btn" ng-class="{Active:'btn-success', Inactive:''}[c.status]" ng-click="changeProductStatus(c);">{{c.status}}</button>
                </td>
                <td style="width:100px">
                    <div class="btn-group">
                      <button type="button" class="btn btn-default fa fa-edit" ng-click="open(c);"></button>
                      <button type="button" class="btn btn-danger fa fa-trash-o" ng-click="deleteProduct(c);"></button>
                    </div>
                </td>
            </tr>-->
                <tr ng-repeat="data in users.filtered = (users.products | filter:users.search | orderBy : users.predicate :users.reverse) | startFrom:(users.currentPage-1) * users.entryLimit | limitTo:users.entryLimit">
                    <!--<tr ng-repeat="data in products | filter:filterProduct | orderBy:'-id'" id="{{data.id}}" animate-on-change='data.packing + data.stock + data.price + data.description' ng-animate=" 'animate'">-->
                    <td>{{data.id}}</td>
                    <td>{{data.name}}</td>
                    <td>{{data.price}}</td>
                    <td>{{data.stock}}</td>
                    <td>{{data.packing}}</td>
                    <td>{{data.description}}</td>
                    <td>{{data.status}}</td>
                </tr>

            </table>
        </div>
        </div>
    </div>
</div>