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
 * @interface OrderSalesStatisticsResponseDTO
 */
export interface OrderSalesStatisticsResponseDTO {
    /**
     * Unique identifier for the category
     * @type {number}
     * @memberof OrderSalesStatisticsResponseDTO
     */
    'categoryId': number;
    /**
     * Name of the category
     * @type {string}
     * @memberof OrderSalesStatisticsResponseDTO
     */
    'categoryName': string;
    /**
     * Number of products in the category
     * @type {number}
     * @memberof OrderSalesStatisticsResponseDTO
     */
    'numberOfProductsPerCategory': number;
    /**
     * Average rating of products in the category
     * @type {number}
     * @memberof OrderSalesStatisticsResponseDTO
     */
    'averageRating': number;
    /**
     * Total sales for the category
     * @type {number}
     * @memberof OrderSalesStatisticsResponseDTO
     */
    'totalSalesPerCategory': number;
    /**
     * Unique identifier for the top selling product
     * @type {number}
     * @memberof OrderSalesStatisticsResponseDTO
     */
    'productId': number;
    /**
     * Name of the top selling product
     * @type {string}
     * @memberof OrderSalesStatisticsResponseDTO
     */
    'topSalesProductName': string;
    /**
     * Total sales of the top selling product
     * @type {number}
     * @memberof OrderSalesStatisticsResponseDTO
     */
    'topSalesOfProduct': number;
}

