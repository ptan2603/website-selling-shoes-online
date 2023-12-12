import React, { useState, useEffect} from "react";
import { useNavigate } from "react-router-dom";
import { isEnoughCartItem } from "../api/CartApi";
import { toast } from "react-toastify";

import "../static/css/style.css"

const Cart = (props) => {
  const [cart, setCart] = useState([]);
  const [totalPrices, setTotalPrices] = useState({}); // Thêm biến trạng thái cho giá tiền
  const navigate  = useNavigate();

  useEffect(() => {
    onLoad();
  }, []);

// Tạo một danh sách sản phẩm bằng cách sao chép danh sách sản phẩm đã được thêm vào giỏ hàng.
  const onLoad = () => {
    const initialTotalPrices = {};  
    props.cartItem.forEach(item => {
      initialTotalPrices[item.id] = item.price * item.quantity;
    });
      setCart(props.cartItem.map((item) => ({ ...item, checked: false })));
      setTotalPrices(initialTotalPrices); // Khởi tạo giá tiền ban đầu
      props.outStockHandler(props.cartItem);
  };
  
//sử dụng để thay đổi số lượng, cập nhật giá tiền tương ứng và kiểm tra xem số lượng
  const modifyCartItemHandler = (attr, quantity) => {
    isEnoughCartItem(attr, quantity)
          .then(() => {
            const res = cart.map((item) =>
              item.id === attr ? { ...item, quantity: quantity } : item
            );
            const updatedTotalPrices = { ...totalPrices };
            updatedTotalPrices[attr] = res.find((item) => item.id === attr).price * quantity;

            const flag = res.filter((item) => item.quantity > 0);
            setCart(flag);
            setTotalPrices(updatedTotalPrices); // Cập nhật giá tiền
            props.cartHandler(flag);
          })
          .catch((error) => {
            const res = cart.map((item) =>
              item.id === attr ? { ...item, quantity: 1 } : item
            );
            const flag = res.filter((item) => item.quantity > 0);
            setCart(flag);
            props.cartHandler(flag);
            toast.warning(error.response.data.Errors);
          });
  };
// tăng số lượng sản phẩm và cập nhật giá tiền tương ứng, kiểm tra số lượng 
  const addCartItemHandler = (attr, quantity) => {
    isEnoughCartItem(attr, quantity)
    .then(() => {
      const res = cart.map((item) =>
        item.id === attr ? { ...item, quantity: quantity } : item
      );
      const updatedTotalPrices = { ...totalPrices };
      const item = res.find((item) => item.id === attr);
      updatedTotalPrices[attr] = item.price * item.quantity;

      const flag = res.filter((item) => item.quantity > 0);
      setCart(flag);
      setTotalPrices(updatedTotalPrices);
      props.cartHandler(flag);
    })
    .catch((error) => {
      toast.warning(error.response.data.Errors);
    });
  };

// sự kiện nhấn nút chọn
  const buyHandler = (e) => {
    const id = e.target.value;
    const index = cart.findIndex((item) => item.id == id);
    const flag = cart[index].checked;
    if (flag) {
      cart[index] = {
        ...cart[index],
        checked: false,
      };
      props.cancelBuyHandler(id);
    } else {
      cart[index] = {
        ...cart[index],
        checked: true,
      };
      props.buyHandler(id);
    }
  };
// xóa bỏ một sản phẩm khỏi giỏ 
  const removeCartItemHandler = (attr) => {
      const res = cart.filter((item) => item.id !== attr);
      setCart(res);
      props.cartHandler(res);
  };
  
  const checkOutHandler = () => {
    if (props.buy.length === 0) {
      toast.warning("Bạn vẫn chưa chọn sản phẩm nào để mua.");
    } else {
      for (let j = 0; j < props.buy.length; j++) {
        for (let i = 0; i < cart.length; i++) {
          if (props.buy[j] == cart[i].id) {
            isEnoughCartItem(cart[i].id, cart[i].quantity)
              .then((resp) => console.log(resp.data))
          }
        }
      }
      navigate("/muahang");
    }
  };
  
  return (

    <div className="col-12">
      <div className="container-fluid mb-5 mt-5">

        <div className="mini-card">
          <h4 className="text-danger">Giỏ hàng của bạn</h4>
        </div>

        <div className="">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th scope="col">Chọn</th>
                <th scope="col">Ảnh</th>
                <th scope="col">Tên</th>
                <th scope="col">Size</th>
                <th scope="col">Đơn giá</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Thành tiền</th>
                <th scope="col">Xoá</th>
              </tr>
            </thead>

            <tbody>
              {cart &&cart.map((item, index) => (
                  <tr key={index}>

                  <th>
                  <input
                    className="form-check-input ml-1 mt-5"
                    type="checkbox"
                    value={item.id}
                    id="defaultCheck1"
                    onClick={buyHandler}
                  />

                </th>
                    <th>
                      <img
                        className="img-fluid"
                        style={{ width: "100px", height: "100px" }}
                        src={require(`../static/image/${item.image}`)}
                        alt=""
                      />
                    </th>

                    <td>
                      <h6 className="card-title mt-5 bolder">{item.name}</h6>
                    </td>

                    <td>
                      <h6 className="card-title mt-5 bolder">{item.size}</h6>
                    </td>

                    <td>
                      <h6 className="card-title mt-5 bolder">
                        {(item.price ).toLocaleString()}{" "}đ

                      </h6>
                    </td>
                  
                    <td>
                      <div className="mt-5">
                        <button className="btn btn-outline-dark" 
                                onClick={() => addCartItemHandler(item.id, item.quantity + 1)}>
                          +
                        </button>
                        
                        <input
                          type="number"
                          name="quantity"
                          className="text-center"
                          style={{ width: "40px" }}
                          value={item.quantity}
                          onChange={(e) => modifyCartItemHandler(item.id, e.target.value)}
                          min={1}
                        />

                        <button
                          className="btn btn-outline-dark"
                          onClick={() =>modifyCartItemHandler(item.id, item.quantity - 1)}
                          disabled={item.quantity == 1}
                        >
                          -
                        </button>
                      </div>
                    </td>

                    <td>
                      <h6 className="card-title mt-5 bolder">
                      {(totalPrices[item.id] || item.price).toLocaleString()} đ 
                      </h6>
                    </td>

                    <td>
                      <button className="mt-4 btn btn-outline-danger mt-4"  onClick={() => removeCartItemHandler(item.id)} >
                         Xoá
                      </button>
                    </td>
                  </tr>
                ))}
            </tbody>
          </table>

          <hr className="my-4" />

          <div className="row container-fluid">
            <button className="btn btn-primary mb-3 btn-lg"
            onClick={checkOutHandler}
             > Mua hàng </button>
          </div>

        </div>
      </div>
    </div>
  );
};

export default Cart;
