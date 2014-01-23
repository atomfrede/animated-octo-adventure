'use strict';

angular.module('ng-dashboard', [
                             'ng-dashboard.services.findbugs',
                             'ng-dashboard.controllers.findbugs',
                             'ng-dashboard.services.checkstyle',
                             'ng-dashboard.controllers.checkstyle',
                             'ng-dashboard.services.analysis',
                             'ng-dashboard.controllers.analysis',
                             'ng-dashboard.services.dry',
                             'ng-dashboard.controllers.dry',
                             'ng-dashboard.services.buildjob',
                             'ng-dashboard.controllers.buildjob',
                             'ng-dashboard.services.testreport',
                             'ng-dashboard.controllers.testreport'
                             ]);
                        