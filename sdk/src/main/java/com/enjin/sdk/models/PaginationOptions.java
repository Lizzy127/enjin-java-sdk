/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;

/**
 * Models a pagination input for pagination requests.
 *
 * @see com.enjin.sdk.schemas.shared.arguments.PaginationArguments
 */
@EqualsAndHashCode
public class PaginationOptions {

    private Integer page;
    private Integer limit;

    /**
     * Sets the page number to start at.
     *
     * @param page the page
     * @return this input for chaining
     */
    public PaginationOptions page(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Sets the number of results to return per page.
     *
     * @param limit the limit
     * @return this input for chaining
     */
    public PaginationOptions limit(Integer limit) {
        this.limit = limit;
        return this;
    }

}
