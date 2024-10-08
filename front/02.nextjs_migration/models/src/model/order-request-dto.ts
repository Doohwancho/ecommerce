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
 * @interface OrderRequestDTO
 */
export interface OrderRequestDTO {
    /**
     * 
     * @type {number}
     * @memberof OrderRequestDTO
     */
    'memberId': number;
    /**
     * 
     * @type {number}
     * @memberof OrderRequestDTO
     */
    'productItemId': number;
    /**
     * 
     * @type {number}
     * @memberof OrderRequestDTO
     */
    'order_quantity': number;
    /**
     * 
     * @type {number}
     * @memberof OrderRequestDTO
     */
    'price': number;
    /**
     * 
     * @type {number}
     * @memberof OrderRequestDTO
     */
    'discountId'?: number;
    /**
     * Type of the discount
     * @type {string}
     * @memberof OrderRequestDTO
     */
    'discountType'?: string;
    /**
     * Value of the discount
     * @type {number}
     * @memberof OrderRequestDTO
     */
    'discountValue'?: number;
    /**
     * Start date of the discount
     * @type {string}
     * @memberof OrderRequestDTO
     */
    'startDate'?: string;
    /**
     * End date of the discount
     * @type {string}
     * @memberof OrderRequestDTO
     */
    'endDate'?: string;
    /**
     * 
     * @type {number}
     * @memberof OrderRequestDTO
     */
    'optionId'?: number;
    /**
     * 
     * @type {number}
     * @memberof OrderRequestDTO
     */
    'optionVariationId': number;
    /**
     * 
     * @type {string}
     * @memberof OrderRequestDTO
     */
    'optionVariationName'?: string;
}

