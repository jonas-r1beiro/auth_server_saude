"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.LRU = void 0;
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
class LRU {
    constructor(max = 2) {
        this.max = max;
        this.cache = [];
    }
    get() {
        return this.cache;
    }
    set(item) {
        const index = this.cache.indexOf(item);
        if (index >= 0) {
            this.cache.splice(index, 1);
        }
        this.cache.push(item);
        if (this.cache.length > this.max) {
            this.cache.shift();
        }
    }
    clear() {
        this.cache.length = 0;
    }
}
exports.LRU = LRU;
//# sourceMappingURL=lru.js.map