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

package com.enjin.sdk.schemas.shared;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.models.Balance;
import com.enjin.sdk.models.GasPrices;
import com.enjin.sdk.models.Platform;
import com.enjin.sdk.models.Project;
import com.enjin.sdk.models.Request;
import com.enjin.sdk.models.Asset;
import com.enjin.sdk.schemas.shared.mutations.CancelTransaction;
import com.enjin.sdk.services.BalanceService;
import com.enjin.sdk.schemas.BaseSchema;
import com.enjin.sdk.services.PlatformService;
import com.enjin.sdk.services.ProjectService;
import com.enjin.sdk.services.RequestService;
import com.enjin.sdk.services.AssetService;
import com.enjin.sdk.schemas.shared.queries.GetBalances;
import com.enjin.sdk.schemas.shared.queries.GetGasPrices;
import com.enjin.sdk.schemas.shared.queries.GetPlatform;
import com.enjin.sdk.schemas.shared.queries.GetProject;
import com.enjin.sdk.schemas.shared.queries.GetRequest;
import com.enjin.sdk.schemas.shared.queries.GetRequests;
import com.enjin.sdk.schemas.shared.queries.GetAsset;
import com.enjin.sdk.schemas.shared.queries.GetAssets;
import com.enjin.sdk.utils.LoggerProvider;

import java.io.IOException;
import java.util.List;

/**
 * Class for sending requests shared across schemas.
 */
public class SharedSchema extends BaseSchema implements ISharedSchema {

    protected final BalanceService balanceService;
    protected final PlatformService platformService;
    protected final ProjectService projectService;
    protected final RequestService requestService;
    protected final AssetService assetService;

    /**
     * Sole constructor, used internally.
     *
     * @param middleware     the middleware
     * @param schema         the schema
     * @param loggerProvider the logger provider
     */
    public SharedSchema(TrustedPlatformMiddleware middleware, String schema, LoggerProvider loggerProvider) {
        super(middleware, schema, loggerProvider);
        balanceService = (BalanceService) createService(BalanceService.class);
        platformService = (PlatformService) createService(PlatformService.class);
        projectService = (ProjectService) createService(ProjectService.class);
        requestService = (RequestService) createService(RequestService.class);
        assetService = (AssetService) createService(AssetService.class);
    }

    /**
     * Sends {@link CancelTransaction} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Boolean> cancelTransaction(CancelTransaction request) {
        return sendRequest(requestService.delete(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link CancelTransaction} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void cancelTransaction(CancelTransaction request,
                                  HttpCallback<GraphQLResponse<Boolean>> callback) {
        sendRequest(requestService.delete(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetAsset} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Asset> getAsset(GetAsset request) {
        return sendRequest(assetService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetAsset} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getAsset(GetAsset request,
                         HttpCallback<GraphQLResponse<Asset>> callback) {
        sendRequest(assetService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetAssets} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<List<Asset>> getAssets(GetAssets request) {
        return sendRequest(assetService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetAssets} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getAssets(GetAssets request,
                          HttpCallback<GraphQLResponse<List<Asset>>> callback) {
        sendRequest(assetService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetBalances} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<List<Balance>> getBalances(GetBalances request) {
        return sendRequest(balanceService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetBalances} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getBalances(GetBalances request,
                            HttpCallback<GraphQLResponse<List<Balance>>> callback) {
        sendRequest(balanceService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetGasPrices} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<GasPrices> getGasPrices(GetGasPrices request) {
        return sendRequest(platformService.getGasPrices(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetGasPrices} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getGasPrices(GetGasPrices request,
                             HttpCallback<GraphQLResponse<GasPrices>> callback) {
        sendRequest(platformService.getGasPrices(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetPlatform} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Platform> getPlatform(GetPlatform request) {
        return sendRequest(platformService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetPlatform} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getPlatform(GetPlatform request,
                            HttpCallback<GraphQLResponse<Platform>> callback) {
        sendRequest(platformService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetProject} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Project> getProject(GetProject request) {
        return sendRequest(projectService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetProject} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getProject(GetProject request,
                           HttpCallback<GraphQLResponse<Project>> callback) {
        sendRequest(projectService.getOne(schema, createRequestBody(request)), callback);
    }

    /**
     * Sends {@link GetRequest} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<Request> getRequest(GetRequest request) {
        return transactionRequest(request);
    }

    /**
     * Sends {@link GetRequest} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getRequest(GetRequest request,
                           HttpCallback<GraphQLResponse<Request>> callback) {
        transactionRequest(request, callback);
    }

    /**
     * Sends {@link GetRequests} request synchronously.
     *
     * @param request the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    @Override
    public GraphQLResponse<List<Request>> getRequests(GetRequests request) {
        return sendRequest(requestService.getMany(schema, createRequestBody(request)));
    }

    /**
     * Sends {@link GetRequests} request asynchronously.
     *
     * @param request  the request
     * @param callback the callback
     */
    @Override
    public void getRequests(GetRequests request,
                            HttpCallback<GraphQLResponse<List<Request>>> callback) {
        sendRequest(requestService.getMany(schema, createRequestBody(request)), callback);
    }

    /**
     * Helper method for sending synchronous transaction requests.
     *
     * @param request the request
     * @param <T>     the type of the request
     *
     * @return the response
     *
     * @throws IOException if a problem occurred talking to the server
     */
    protected <T extends GraphQLRequest<T>> GraphQLResponse<Request> transactionRequest(GraphQLRequest<T> request) {
        return sendRequest(requestService.getOne(schema, createRequestBody(request)));
    }

    /**
     * Helper method for sending asynchronous transaction requests.
     *
     * @param request  the request
     * @param callback the callback
     * @param <T>      the type of the request
     */
    protected <T extends GraphQLRequest<T>> void transactionRequest(GraphQLRequest<T> request,
                                                                    HttpCallback<GraphQLResponse<Request>> callback) {
        sendRequest(requestService.getOne(schema, createRequestBody(request)), callback);
    }

}
