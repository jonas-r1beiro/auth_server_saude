"use strict";
/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2023 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
// https://sonarsource.github.io/rspec/#/rspec/S6441/javascript
Object.defineProperty(exports, "__esModule", { value: true });
exports.rule = void 0;
const eslint_plugin_react_hooks_1 = require("eslint-plugin-react-hooks");
const helpers_1 = require("../helpers");
const helpers_2 = require("../helpers");
const rulesOfHooks = eslint_plugin_react_hooks_1.rules['rules-of-hooks'];
exports.rule = {
    meta: rulesOfHooks.meta,
    create(context) {
        function overrideContext(overrides) {
            Object.setPrototypeOf(overrides, context);
            return overrides;
        }
        let isReact = false;
        const detectReactListener = helpers_1.rule.create(overrideContext({
            report(_descriptor) {
                isReact = true;
            },
        }));
        const rulesOfHooksListener = rulesOfHooks.create(overrideContext({
            report(descriptor) {
                if (isReact) {
                    context.report(descriptor);
                }
            },
        }));
        return (0, helpers_2.mergeRules)(detectReactListener, rulesOfHooksListener);
    },
};
//# sourceMappingURL=rule.js.map