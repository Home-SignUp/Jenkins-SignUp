<div ng-controller="RegisterCtrl as register">
    <form class="form-horizontal" role="form" ng-submit="register.createProduct()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Create a new user:</label>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">NAME</label>
            <div class="col-sm-4">
                <input class="form-control" id="name" placeholder="NAME" ng-model="register.name" ng-required="true">
                <!--<span ng-show="register.nameRequired">{{register.nameRequired}}</span>-->
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">DESCRIPTION</label>
            <div class="col-sm-4">
                <textarea class="form-control" name="description" placeholder="DESCRIPTION" ng-model="register.description" ng-required="true">{{register.description}}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">PRICE</label>
            <div class="col-sm-4">
                <input class="form-control" id="price" placeholder="PRICE" ng-model="register.price">
                <span ng-show="register.priceRequired">{{register.priceRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="stock" class="col-sm-2 control-label">STOCK</label>
            <div class="col-sm-4">
                <input class="form-control" id="stock" placeholder="STOCK" ng-model="register.stock">
                <span ng-show="register.stockRequired">{{register.stockRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="packing" class="col-sm-2 control-label">PACKING</label>
            <div class="col-sm-4">
                <input class="form-control" id="packing" placeholder="PACKING" ng-model="register.packing">
                <span ng-show="register.packingRequired">{{register.packingRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-success" />
            </div>
        </div>

        <p ng-show="register.newUserId">
            User created with id: {{register.newUserId}}
        </p>
    </form>

    <!--<hr />

    <div>
        <form class="form-horizontal" role="form" ng-submit="register.searchProduct()">
            <div class="form-group">
                <label class="col-sm-2 control-label">Check a user by:</label>
            </div>
            <div class="form-group">
                <label for="searchProductId" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-4">
                    <input class="form-control" id="searchProductId" placeholder="ID" ng-model="register.searchProductId" ng-required="true" />
                </div>
            </div>
        </form>

        <div class="searchOutput">{{register.product | json}}</div>
    </div>-->
</div>
