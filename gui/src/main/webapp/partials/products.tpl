    <hr/>
    <button type="button" class="btn btn-danger fa fa-plus" ng-click="open(product);">&nbsp;Add New Product</button>

    <div class="table-responsive">
        <div class="panel panel-primary">
          <div class="panel-heading">
              List of products
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
                            <input placeholder="Filter products list ..." class="nav-search-input" ng-model="search" ng-change="filter()" autocomplete="off" type="text" style="width:300px;" focus>
                            <i class="search-icon fa fa-search nav-search-icon"></i>
                        </span>
                        Filtered {{filtered.length}} of {{totalItems}} total products
                    </div>
                </div>
            </div>
          <div class="panel-body">
            <table class="table table-striped">
                <tr ng-show="products.length==0"><td style="vertical-align:middle;"><i class="fa fa-ban fa-3x"></i>&nbsp;No data found</td></tr>
                <tr ng-hide="products.length>-1"><td style="vertical-align:middle;"><i class="fa fa-cog fa-3x fa-spin"></i>&nbsp;Loading</td></tr>
                <tr>
                    <th>ID&nbsp;<a ng-click="sort_by('id');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Name&nbsp;<a ng-click="sort_by('name');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Price&nbsp;<a ng-click="sort_by('price');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Stock&nbsp;<a ng-click="sort_by('stock');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Packing&nbsp;<a ng-click="sort_by('packing');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Description&nbsp;<a ng-click="sort_by('description');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Status&nbsp;<a ng-click="sort_by('status');"><i class="glyphicon glyphicon-sort"></i></a></th>
                    <th>Action</th>
                </tr>
                <tr ng-repeat="data in filtered = (products | filter:search | orderBy : predicate :reverse) | startFrom:(currentPage-1) * entryLimit | limitTo:entryLimit" animate-on-change='data.packing + data.stock + data.price + data.description' ng-animate=" 'animate'">
                    <td>{{data.id}}</td>
                    <td>{{data.name}}</td>
                    <td>{{data.price}}</td>
                    <td>{{data.stock}}</td>
                    <td>{{data.packing}}</td>
                    <td>{{data.description}}</td>
                    <td>
                        <button class="btn" ng-class="{Active:'btn-success', Inactive:''}[data.status]" ng-click="changeProductStatus(data);">{{data.status}}</button>
                    </td>
                    <td style="width:100px">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default fa fa-edit" ng-click="open(data);"></button>
                            <button type="button" class="btn btn-danger fa fa-trash-o" ng-click="deleteProduct(data);"></button>
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