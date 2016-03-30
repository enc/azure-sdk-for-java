/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch;

import com.microsoft.azure.PagedList;
import com.microsoft.azure.batch.protocol.models.*;
import com.microsoft.rest.ServiceResponseWithHeaders;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

public class ComputeNodeOperations implements IInheritedBehaviors {

    private Collection<BatchClientBehavior> _customBehaviors;

    private BatchClient _parentBatchClient;

    ComputeNodeOperations(BatchClient batchClient, Iterable<BatchClientBehavior> inheritedBehaviors) {
        _parentBatchClient = batchClient;

        // inherit from instantiating parent
        InternalHelper.InheritClientBehaviorsAndSetPublicProperty(this, inheritedBehaviors);
    }

    @Override
    public Collection<BatchClientBehavior> getCustomBehaviors() {
        return _customBehaviors;
    }

    @Override
    public void setCustomBehaviors(Collection<BatchClientBehavior> behaviors) {
        this._customBehaviors = behaviors;
    }

    public void addComputeNodeUser(String poolId, String nodeId, ComputeNodeUser user) throws BatchErrorException, IOException {
        addComputeNodeUser(poolId, nodeId, user, null);
    }

    public void addComputeNodeUser(String poolId, String nodeId, ComputeNodeUser user, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeAddUserOptions options = new ComputeNodeAddUserOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.applyRequestBehaviors(options);

        this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().addUser(poolId, nodeId, user, options);
    }

    public void deleteComputeNodeUser(String poolId, String nodeId, String userName) throws BatchErrorException, IOException {
        deleteComputeNodeUser(poolId, nodeId, userName, null);
    }

    public void deleteComputeNodeUser(String poolId, String nodeId, String userName, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeDeleteUserOptions options = new ComputeNodeDeleteUserOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.applyRequestBehaviors(options);

        this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().deleteUser(poolId, nodeId, userName, options);
    }

    public void updateComputeNodeUser(String poolId, String nodeId, String userName, String password, DateTime expiryTime) throws BatchErrorException, IOException {
        updateComputeNodeUser(poolId, nodeId, userName, password, expiryTime, null);
    }

    public void updateComputeNodeUser(String poolId, String nodeId, String userName, String password, DateTime expiryTime, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        NodeUpdateUserParameter param = new NodeUpdateUserParameter();
        param.setPassword(password);
        param.setExpiryTime(expiryTime);

        updateComputeNodeUser(poolId, nodeId, userName, param, additionalBehaviors);
    }

    private void updateComputeNodeUser(String poolId, String nodeId, String userName, NodeUpdateUserParameter nodeUpdateUserParameter, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeUpdateUserOptions options = new ComputeNodeUpdateUserOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.applyRequestBehaviors(options);

        this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().updateUser(poolId, nodeId, userName, nodeUpdateUserParameter, options);
    }

    public ComputeNode getComputeNode(String poolId, String nodeId) throws BatchErrorException, IOException {
        return getComputeNode(poolId, nodeId, null, null);
    }


    public ComputeNode getComputeNode(String poolId, String nodeId, DetailLevel detailLevel) throws BatchErrorException, IOException {
        return getComputeNode(poolId, nodeId, detailLevel, null);
    }

    public ComputeNode getComputeNode(String poolId, String nodeId, DetailLevel detailLevel, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeGetOptions options = new ComputeNodeGetOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.appendDetailLevelToPerCallBehaviors(detailLevel);
        bhMgr.applyRequestBehaviors(options);

        ServiceResponseWithHeaders<ComputeNode, ComputeNodeGetHeaders> response = this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().get(poolId, nodeId, options);

        return response.getBody();
    }

    public void rebootComputeNode(String poolId, String nodeId) throws BatchErrorException, IOException {
        rebootComputeNode(poolId, nodeId, null, null);
    }

    public void rebootComputeNode(String poolId, String nodeId, ComputeNodeRebootOption nodeRebootOption) throws BatchErrorException, IOException {
        rebootComputeNode(poolId, nodeId, nodeRebootOption, null);
    }

    public void rebootComputeNode(String poolId, String nodeId, ComputeNodeRebootOption nodeRebootOption, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeRebootOptions options = new ComputeNodeRebootOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.applyRequestBehaviors(options);

        this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().reboot(poolId, nodeId, nodeRebootOption, options);
    }

    public void reimageComputeNode(String poolId, String nodeId) throws BatchErrorException, IOException {
        reimageComputeNode(poolId, nodeId, null, null);
    }

    public void reimageComputeNode(String poolId, String nodeId, ComputeNodeReimageOption nodeReimageOption) throws BatchErrorException, IOException {
        reimageComputeNode(poolId, nodeId, nodeReimageOption, null);
    }

    public void reimageComputeNode(String poolId, String nodeId, ComputeNodeReimageOption nodeReimageOption, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeReimageOptions options = new ComputeNodeReimageOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.applyRequestBehaviors(options);

        this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().reimage(poolId, nodeId, nodeReimageOption, options);
    }

    public void disableComputeNodeScheduling(String poolId, String nodeId) throws BatchErrorException, IOException {
        disableComputeNodeScheduling(poolId, nodeId, null, null);
    }

    public void disableComputeNodeScheduling(String poolId, String nodeId, DisableComputeNodeSchedulingOption nodeDisableSchedulingOption) throws BatchErrorException, IOException {
        disableComputeNodeScheduling(poolId, nodeId, nodeDisableSchedulingOption, null);
    }

    public void disableComputeNodeScheduling(String poolId, String nodeId, DisableComputeNodeSchedulingOption nodeDisableSchedulingOption, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeDisableSchedulingOptions options = new ComputeNodeDisableSchedulingOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.applyRequestBehaviors(options);

        this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().disableScheduling(poolId, nodeId, nodeDisableSchedulingOption, options);
    }

    public void enableComputeNodeScheduling(String poolId, String nodeId) throws BatchErrorException, IOException {
        enableComputeNodeScheduling(poolId, nodeId, null);
    }

    public void enableComputeNodeScheduling(String poolId, String nodeId, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeEnableSchedulingOptions options = new ComputeNodeEnableSchedulingOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.applyRequestBehaviors(options);

        this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().enableScheduling(poolId, nodeId, options);
    }

    public InputStream getComputeNodeRemoteDesktop(String poolId, String nodeId) throws BatchErrorException, IOException {
        return getComputeNodeRemoteDesktop(poolId, nodeId, null);
    }

    public InputStream getComputeNodeRemoteDesktop(String poolId, String nodeId, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeGetRemoteDesktopOptions options = new ComputeNodeGetRemoteDesktopOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.applyRequestBehaviors(options);

        ServiceResponseWithHeaders<InputStream, ComputeNodeGetRemoteDesktopHeaders> response = this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().getRemoteDesktop(poolId, nodeId, options);

        return response.getBody();
    }

    public List<ComputeNode> listComputeNodes(String poolId) throws BatchErrorException, IOException {
        return listComputeNodes(poolId, null, null);
    }

    public List<ComputeNode> listComputeNodes(String poolId, DetailLevel detaiLevel) throws BatchErrorException, IOException {
        return listComputeNodes(poolId, detaiLevel, null);
    }

    public List<ComputeNode> listComputeNodes(String poolId, DetailLevel detailLevel, Iterable<BatchClientBehavior> additionalBehaviors) throws BatchErrorException, IOException {
        ComputeNodeListOptions options = new ComputeNodeListOptions();
        BehaviorManager bhMgr = new BehaviorManager(this.getCustomBehaviors(), additionalBehaviors);
        bhMgr.appendDetailLevelToPerCallBehaviors(detailLevel);
        bhMgr.applyRequestBehaviors(options);

        ServiceResponseWithHeaders<PagedList<ComputeNode>, ComputeNodeListHeaders> response = this._parentBatchClient.getProtocolLayer().getComputeNodeOperations().list(poolId, options);

        return response.getBody();
    }

}