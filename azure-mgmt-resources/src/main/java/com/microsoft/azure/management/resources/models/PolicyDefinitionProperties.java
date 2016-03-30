/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.models;


/**
 * Policy definition properties.
 */
public class PolicyDefinitionProperties {
    /**
     * Gets or sets the policy definition description.
     */
    private String description;

    /**
     * Gets or sets the policy definition display name.
     */
    private String displayName;

    /**
     * The policy rule json.
     */
    private Object policyRule;

    /**
     * Get the description value.
     *
     * @return the description value
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description value.
     *
     * @param description the description value to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the displayName value.
     *
     * @return the displayName value
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Set the displayName value.
     *
     * @param displayName the displayName value to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the policyRule value.
     *
     * @return the policyRule value
     */
    public Object getPolicyRule() {
        return this.policyRule;
    }

    /**
     * Set the policyRule value.
     *
     * @param policyRule the policyRule value to set
     */
    public void setPolicyRule(Object policyRule) {
        this.policyRule = policyRule;
    }

}