<div ng-controller="SignupCtrl as signup">
    <form class="form-horizontal" role="form" ng-submit="signup.createProduct()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Signup user:</label>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">NAME</label>
            <div class="col-sm-4">
                <input class="form-control" id="name" placeholder="NAME" ng-model="signup.name" ng-required="true">
                <!--<span ng-show="signup.nameRequired">{{signup.nameRequired}}</span>-->
            </div>
        </div>
        <!--<div class="form-group">
            <label for="description" class="col-sm-2 control-label">DESCRIPTION</label>
            <div class="col-sm-4">
                <textarea class="form-control" name="description" placeholder="DESCRIPTION" ng-model="signup.description" ng-required="true">{{signup.description}}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">PRICE</label>
            <div class="col-sm-4">
                <input class="form-control" id="price" placeholder="PRICE" ng-model="signup.price">
                <span ng-show="signup.priceRequired">{{signup.priceRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="stock" class="col-sm-2 control-label">STOCK</label>
            <div class="col-sm-4">
                <input class="form-control" id="stock" placeholder="STOCK" ng-model="signup.stock">
                <span ng-show="signup.stockRequired">{{signup.stockRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="packing" class="col-sm-2 control-label">PACKING</label>
            <div class="col-sm-4">
                <input class="form-control" id="packing" placeholder="PACKING" ng-model="signup.packing">
                <span ng-show="signup.packingRequired">{{signup.packingRequired}}</span>
            </div>
        </div>-->
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-success" />
            </div>
        </div>

        <p ng-show="signup.newUserId">
            User created with id: {{signup.newUserId}}
        </p>
    </form>

    <hr />

    <div>
        <form class="form-horizontal" role="form" ng-submit="signup.searchProduct()">
            <div class="form-group">
                <label class="col-sm-2 control-label">Check a user by:</label>
            </div>
            <div class="form-group">
                <label for="searchProductId" class="col-sm-2 control-label">ID</label>
                <div class="col-sm-4">
                    <input class="form-control" id="searchProductId" placeholder="ID" ng-model="signup.searchProductId" ng-required="true" />
                </div>
            </div>
        </form>

        <div class="searchOutput">{{signup.product | json}}</div>
    </div>
</div>
