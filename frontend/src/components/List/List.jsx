import React from "react";
import "./List.scss";
import Card from "../Card/Card";
//import useFetch from "../../hooks/useFetch";

const data = [
	{
		id:1,
		img: "https://images.pexels.com/photos/1972115/pexels-photo-1972115.jpeg?auto=compress&cs-tinysrgb&w=1600",
		img2: "https://images.pexels.com/photos/1972115/pexels-photo-1163194.jpeg?auto=compress&cs-tinysrgb&w=1600",
		title: "Long Sleeves Graphic T-shirt",
		isNew:true,
		oldPrice: 19,
		price:5
	},
	{
		id:2,
		img: "https://images.pexels.com/photos/5119838/pexels-photo-5119838.jpeg?auto=compress&cs-tinysrgb&w=1600",
		img2: "https://images.pexels.com/photos/14610789/pexels-photo-1163194.jpeg?auto=compress&cs-tinysrgb&w=1600",
		title: "Long Sleeves Graphic T-shirt",
		isNew:true,
		oldPrice: 19,
		price:7
	},	
	{
		id:3,
		img: "https://images.pexels.com/photos/6968340/pexels-photo-6968340.jpeg?auto=compress&cs-tinysrgb&w=1600",
		img2: "https://images.pexels.com/photos/6968340/pexels-photo-1163194.jpeg?auto=compress&cs-tinysrgb&w=1600",
		title: "Long Sleeves Graphic T-shirt",
		isNew:true,
		oldPrice: 19,
		price:8
	},
	{
		id:4,
		img: "https://images.pexels.com/photos/13622696/pexels-photo-13622696.jpeg?auto=compress&cs-tinysrgb&w=1600",
		img2: "https://images.pexels.com/photos/1972115/pexels-photo-1163194.jpeg?auto=compress&cs-tinysrgb&w=1600",
		title: "Long Sleeves Graphic T-shirt",
		isNew:true,
		oldPrice: 19,
		price:10
	},
]

const List = ({}) => {
//   const { data, loading, error } = useFetch(
//     `/products?populate=*&[filters][categories][id]=${catId}${subCats.map(
//       (item) => `&[filters][sub_categories][id][$eq]=${item}`
//     )}&[filters][price][$lte]=${maxPrice}&sort=price:${sort}`
//   );

  return (
    <div className="list">
      {data?.map((item) => <Card item={item} key={item.id} />)}
    </div>
  );
};

export default List;
