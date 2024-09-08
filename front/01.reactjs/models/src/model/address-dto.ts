/* tslint:disable */
/* eslint-disable */
/**
 * ecommerce API
 * ecommerce API MVP
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */



/**
 * 
 * @export
 * @interface AddressDTO
 */
export interface AddressDTO {
    /**
     * Street name and number
     * @type {string}
     * @memberof AddressDTO
     */
    'street': string;
    /**
     * City name
     * @type {string}
     * @memberof AddressDTO
     */
    'city': string;
    /**
     * State or province name
     * @type {string}
     * @memberof AddressDTO
     */
    'state': string;
    /**
     * Country name
     * @type {string}
     * @memberof AddressDTO
     */
    'country': string;
    /**
     * Postal or ZIP code
     * @type {string}
     * @memberof AddressDTO
     */
    'zipCode': string;
}
