'use strict';

angular.module('ng-dashboard', [
                             'ng-dashboard.services.findbugs',
                             'ng-dashboard.controllers.findbugs',
                             'ng-dashboard.services.checkstyle',
                             'ng-dashboard.controllers.checkstyle',
                             'ng-dashboard.services.analysis',
                             'ng-dashboard.controllers.analysis'
                             ]);
                        