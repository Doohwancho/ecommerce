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
 * @interface ErrorResponseDTO
 */
export interface ErrorResponseDTO {
    /**
     * 
     * @type {string}
     * @memberof ErrorResponseDTO
     */
    'message': string;
    /**
     * 
     * @type {number}
     * @memberof ErrorResponseDTO
     */
    'status': number;
    /**
     * 
     * @type {Array<string>}
     * @memberof ErrorResponseDTO
     */
    'errors'?: Array<string>;
    /**
     * 
     * @type {string}
     * @memberof ErrorResponseDTO
     */
    'code': string;
}

