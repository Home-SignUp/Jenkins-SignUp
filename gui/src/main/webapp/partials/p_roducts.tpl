<div ng-controller="P_roductsCtrl as p_roducts">
    <div class="container">
    <br/>
    <blockquote><h4><a href="http://jsfiddle.net/mjaric/pJ5BR/">List all users:</a></h4></blockquote>
    <br/>
        <div class="row">
            <div class="col-md-2">PageSize:
                <select ng-model="p_roducts.entryLimit" class="form-control">
                    <option>5</option>
                    <option>10</option>
                    <option>20</option>
                    <option>50</option>
                    <option>100</option>
                </select>
            </div>
            <div class="col-md-3">Filter:
                <input type="text" ng-model="p_roducts.search" ng-change="filter()" placeholder="Filter" class="form-control" />
            </div>
            <div class="col-md-4">
                <h5>Filtered {{p_roducts.filtered.length}} of {{p_roducts.totalItems}} total products</h5>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-12" ng-show="p_roducts.filteredItems > 0">
                <table class="table table-striped table-bordered">
                <thead>
                <th>ID&nbsp;<a ng-click="p_roducts.sort_by('id');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Name&nbsp;<a ng-click="p_roducts.sort_by('name');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Price&nbsp;<a ng-click="p_roducts.sort_by('price');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Stock&nbsp;<a ng-click="p_roducts.sort_by('stock');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Packing&nbsp;<a ng-click="p_roducts.sort_by('packing');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Description&nbsp;<a ng-click="p_roducts.sort_by('description');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Status&nbsp;<a ng-click="p_roducts.sort_by('status');"><i class="glyphicon glyphicon-sort"></i></a></th>
                </thead>
                <tbody>
                    <tr ng-repeat="data in p_roducts.filtered = (p_roducts.list | filter:p_roducts.search | orderBy : p_roducts.predicate :p_roducts.reverse) | startFrom:(p_roducts.currentPage-1) * p_roducts.entryLimit | limitTo:p_roducts.entryLimit">
                        <td>{{data.id}}</td>
                        <td>{{data.name}}</td>
                        <td>{{data.price}}</td>
                        <td>{{data.stock}}</td>
                        <td>{{data.packing}}</td>
                        <td>{{data.description}}</td>
                        <td>{{data.status}}</td>
                    </tr>
                </tbody>
                </table>
            </div>
            <div class="col-md-12" ng-show="p_roducts.filteredItems == 0">
                <div class="col-md-12">
                    <h4>No customers found</h4>
                </div>
            </div>
            <div class="col-md-12" ng-show="p_roducts.filteredItems > 0">
                <div pagination="" page="currentPage" on-select-page="p_roducts.setPage(page)" boundary-links="true" total-items="p_roducts.filteredItems" items-per-page="p_roducts.entryLimit" class="pagination-small" previous-text="&laquo;" next-text="&raquo;"></div>
            </div>
        </div>
    </div>
</div>