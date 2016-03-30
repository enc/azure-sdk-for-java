/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.website.models;


/**
 * Describes if a resource name is available.
 */
public class ResourceNameAvailability {
    /**
     * True indicates name is valid and available.  False indicates the name
     * is invalid, unavailable, or both.
     */
    private Boolean nameAvailable;

    /**
     * Required if nameAvailable is false. 'Invalid' indicates the name
     * provided does not match Azure WebApp serviceâ€™s naming requirements.
     * 'AlreadyExists' indicates that the name is already in use and is
     * therefore unavailable.
     */
    private String reason;

    /**
     * The message property.
     */
    private String message;

    /**
     * Get the nameAvailable value.
     *
     * @return the nameAvailable value
     */
    public Boolean getNameAvailable() {
        return this.nameAvailable;
    }

    /**
     * Set the nameAvailable value.
     *
     * @param nameAvailable the nameAvailable value to set
     */
    public void setNameAvailable(Boolean nameAvailable) {
        this.nameAvailable = nameAvailable;
    }

    /**
     * Get the reason value.
     *
     * @return the reason value
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * Set the reason value.
     *
     * @param reason the reason value to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Get the message value.
     *
     * @return the message value
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Set the message value.
     *
     * @param message the message value to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}