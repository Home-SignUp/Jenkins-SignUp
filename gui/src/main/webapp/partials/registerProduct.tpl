<div ng-controller="RegisterProductCtrl as registerProduct">
    <form class="form-horizontal" role="form" ng-submit="registerProduct.createProduct()" >
        <div class="form-group">
            <label class="col-sm-2 control-label">Create a new user:</label>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">NAME</label>
            <div class="col-sm-4">
                <input class="form-control" id="name" placeholder="NAME" ng-model="registerProduct.name" ng-required="true">
                <!--<span ng-show="registerProduct.nameRequired">{{registerProduct.nameRequired}}</span>-->
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">DESCRIPTION</label>
            <div class="col-sm-4">
                <textarea class="form-control" name="description" placeholder="DESCRIPTION" ng-model="registerProduct.description" ng-required="true">{{registerProduct.description}}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">PRICE</label>
            <div class="col-sm-4">
                <input class="form-control" id="price" placeholder="PRICE" ng-model="registerProduct.price">
                <span ng-show="registerProduct.priceRequired">{{registerProduct.priceRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="stock" class="col-sm-2 control-label">STOCK</label>
            <div class="col-sm-4">
                <input class="form-control" id="stock" placeholder="STOCK" ng-model="registerProduct.stock">
                <span ng-show="registerProduct.stockRequired">{{registerProduct.stockRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="packing" class="col-sm-2 control-label">PACKING</label>
            <div class="col-sm-4">
                <input class="form-control" id="packing" placeholder="PACKING" ng-model="registerProduct.packing">
                <span ng-show="registerProduct.packingRequired">{{registerProduct.packingRequired}}</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-success" />
            </div>
        </div>

        <p ng-show="registerProduct.newUserId">
            User created with id: {{registerProduct.newUserId}}
        </p>
    </form>
</div>
