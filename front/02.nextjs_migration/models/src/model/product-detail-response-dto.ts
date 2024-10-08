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


// May contain unused imports in some cases
// @ts-ignore
import type { DiscountDTO } from './discount-dto';

/**
 * 
 * @export
 * @interface ProductDetailResponseDTO
 */
export interface ProductDetailResponseDTO {
    /**
     * Unique identifier of the product
     * @type {number}
     * @memberof ProductDetailResponseDTO
     */
    'productId': number;
    /**
     * Name of the product
     * @type {string}
     * @memberof ProductDetailResponseDTO
     */
    'name': string;
    /**
     * Description of the product
     * @type {string}
     * @memberof ProductDetailResponseDTO
     */
    'description': string;
    /**
     * Average rating of the product
     * @type {number}
     * @memberof ProductDetailResponseDTO
     */
    'rating': number;
    /**
     * Count of ratings received
     * @type {number}
     * @memberof ProductDetailResponseDTO
     */
    'ratingCount': number;
    /**
     * Available quantity of the product
     * @type {number}
     * @memberof ProductDetailResponseDTO
     */
    'quantity': number;
    /**
     * Price of the product
     * @type {number}
     * @memberof ProductDetailResponseDTO
     */
    'price': number;
    /**
     * 
     * @type {Array<DiscountDTO>}
     * @memberof ProductDetailResponseDTO
     */
    'discounts'?: Array<DiscountDTO>;
    /**
     * Identifier of the category to which the product belongs
     * @type {number}
     * @memberof ProductDetailResponseDTO
     */
    'categoryId': number;
    /**
     * Code of the category
     * @type {string}
     * @memberof ProductDetailResponseDTO
     */
    'categoryCode': string;
    /**
     * Name of the category
     * @type {string}
     * @memberof ProductDetailResponseDTO
     */
    'categoryName': string;
    /**
     * 
     * @type {number}
     * @memberof ProductDetailResponseDTO
     */
    'optionId': number;
    /**
     * Name of the product option
     * @type {string}
     * @memberof ProductDetailResponseDTO
     */
    'optionName': string;
    /**
     * 
     * @type {number}
     * @memberof ProductDetailResponseDTO
     */
    'optionVariationId': number;
    /**
     * Name of the product option variation
     * @type {string}
     * @memberof ProductDetailResponseDTO
     */
    'optionVariationName': string;
}

