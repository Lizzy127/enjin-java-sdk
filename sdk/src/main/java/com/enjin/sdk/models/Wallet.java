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
import lombok.Getter;

import java.util.List;

/**
 * Models a wallet on the platform.
 */
@EqualsAndHashCode
@Getter
public class Wallet {

    /**
     * -- Getter --
     *
     * @return the Ethereum address of this wallet
     */
    private String ethAddress;

    /**
     * -- Getter --
     *
     * @return the ENJ allowance given to crypto items
     */
    private Float enjAllowance;

    /**
     * -- Getter --
     *
     * @return the ENJ balance for this wallet
     */
    private Float enjBalance;

    /**
     * -- Getter --
     *
     * @return the ETH balance for this wallet
     */
    private Float ethBalance;

    /**
     * -- Getter --
     *
     * @return the assets this wallet has created
     */
    private List<Asset> assetsCreated;

    /**
     * -- Getter --
     *
     * @return the balances for this wallet
     */
    private List<Balance> balances;

    /**
     * -- Getter --
     *
     * @return the transactions this wallet has signed
     */
    private List<Request> transactions;

}
