<div ng-controller="CustomersCrtl as customer">
    <div class="container">
    <br/>
    <blockquote><h4><a href="http://jsfiddle.net/mjaric/pJ5BR/">List all users:</a></h4></blockquote>
    <br/>
        <div class="row">
            <div class="col-md-2">PageSize:
                <select ng-model="customer.entryLimit" class="form-control">
                    <option>5</option>
                    <option>10</option>
                    <option>20</option>
                    <option>50</option>
                    <option>100</option>
                </select>
            </div>
            <div class="col-md-3">Filter:
                <input type="text" ng-model="customer.search" ng-change="filter()" placeholder="Filter" class="form-control" />
            </div>
            <div class="col-md-4">
                <h5>Filtered {{ customer.filtered.length }} of {{ customer.totalItems}} total customers</h5>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-md-12" ng-show="customer.filteredItems > 0">
                <table class="table table-striped table-bordered">
                <thead>
                <th>Customer Name&nbsp;<a ng-click="customer.sort_by('customerName');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Address&nbsp;<a ng-click="customer.sort_by('addressLine1');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>City&nbsp;<a ng-click="customer.sort_by('city');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>State&nbsp;<a ng-click="customer.sort_by('state');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Postal Code&nbsp;<a ng-click="customer.sort_by('postalCode');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Country&nbsp;<a ng-click="customer.sort_by('country');"><i class="glyphicon glyphicon-sort"></i></a></th>
                <th>Credit Limit&nbsp;<a ng-click="customer.sort_by('creditLimit');"><i class="glyphicon glyphicon-sort"></i></a></th>
                </thead>
                <tbody>
                    <tr ng-repeat="data in customer.filtered = (customer.list | filter:customer.search | orderBy : customer.predicate :customer.reverse) | startFrom:(customer.currentPage-1) * customer.entryLimit | limitTo:customer.entryLimit">
                        <td>{{data.customerName}}</td>
                        <td>{{data.addressLine1}}</td>
                        <td>{{data.city}}</td>
                        <td>{{data.state}}</td>
                        <td>{{data.postalCode}}</td>
                        <td>{{data.country}}</td>
                        <td>{{data.creditLimit}}</td>
                    </tr>
                </tbody>
                </table>
            </div>
            <div class="col-md-12" ng-show="customer.filteredItems == 0">
                <div class="col-md-12">
                    <h4>No customers found</h4>
                </div>
            </div>
            <div class="col-md-12" ng-show="customer.filteredItems > 0">
                <div pagination="" page="currentPage" on-select-page="customer.setPage(page)" boundary-links="true" total-items="customer.filteredItems" items-per-page="customer.entryLimit" class="pagination-small" previous-text="&laquo;" next-text="&raquo;"></div>
            </div>
        </div>
    </div>
</div>