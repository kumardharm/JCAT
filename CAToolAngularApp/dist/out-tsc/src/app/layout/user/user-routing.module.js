"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var user_component_1 = require("./user.component");
var add_user_component_1 = require("./add-user/add-user.component");
var update_user_component_1 = require("./update-user/update-user.component");
var upload_user_component_1 = require("./upload-user/upload-user.component");
var change_password_component_1 = require("./change-password/change-password.component");
var user_role_component_1 = require("./user-role/user-role.component");
var routes = [
    { path: '', component: user_component_1.UserComponent },
    { path: 'add-user', component: add_user_component_1.AddUserComponent },
    { path: 'user-role', component: user_role_component_1.UserRoleComponent },
    { path: 'update-user', component: update_user_component_1.UpdateUserComponent },
    { path: 'upload-user', component: upload_user_component_1.UploadUserComponent },
    { path: 'change-password', component: change_password_component_1.ChangePasswordComponent },
];
var UserRoutingModule = /** @class */ (function () {
    function UserRoutingModule() {
    }
    UserRoutingModule = __decorate([
        core_1.NgModule({
            imports: [router_1.RouterModule.forChild(routes)],
            exports: [router_1.RouterModule]
        })
    ], UserRoutingModule);
    return UserRoutingModule;
}());
exports.UserRoutingModule = UserRoutingModule;
//# sourceMappingURL=user-routing.module.js.map