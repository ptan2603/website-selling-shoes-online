import "../App.css";

const Footer = () => {
  return (
    <div>
      <footer className="site-footer">
        <div className="container">
          <div className="row">
            <div className="col-sm-12 col-md-6">

              <h6>HỖ TRỢ KHÁCH HÀNG</h6>
              <p className="text-justify">
                <ul>
                  <li>Chăm sóc khách hàng</li>
                  <li>Hướng dẫn mua hàng</li>
                </ul>
              </p>

              <h6>CHÍNH SÁCH</h6>
              <p className="text-justify">
                <ul>
                  <li>Chế độ bảo hành</li>
                  <li>Chính sách đổi trả</li>
                  <li>Bảo mật thông tin</li>
                  <li>Chính sách giao nhận</li>
                </ul>
              </p>
            </div>

            <div className="col-xs-6 col-md-3">
              <h6>THÔNG TIN LIÊN HỆ</h6>

              <ul className="footer-links">
                <li>
                  <span>
                    <b>Địa chỉ</b>
                  </span>
                  <a href="http://scanfcode.com/category/c-language/">
                    <b>: ..../.../.../.../TP.HCM</b>
                  </a>
                </li>
                <li>
                  <span>
                    <b>Email: </b>
                  </span>
                  <a href="http://scanfcode.com/category/c-language/">
                    <b>: ..../.../.../.../@gmail.com</b>
                  </a>
                </li>
                <li>
                  <span>
                    <b>zalo</b>
                  </span>
                  <a href="http://scanfcode.com/category/c-language/">
                    <b>: 0123041220</b>
                  </a>
                </li>
                <li>
                  <span>
                    <b>hotline</b>
                  </span>
                  <a href="http://scanfcode.com/category/c-language/">
                    <b>: 0123041220</b>
                  </a>
                </li>
              </ul>
            </div>

            <div className="col-xs-6 col-md-3">
              <h6>Quick Links</h6>
              <ul className="footer-links">
                <li>
                  <a href="http://scanfcode.com/about/">About Us</a>
                </li>
                <li>
                  <a href="http://scanfcode.com/contact/">Contact Us</a>
                </li>
                <li>
                  <a href="http://scanfcode.com/contribute-at-scanfcode/">
                    Contribute
                  </a>
                </li>
                <li>
                  <a href="http://scanfcode.com/privacy-policy/">
                    Privacy Policy
                  </a>
                </li>
                <li>
                  <a href="http://scanfcode.com/sitemap/">Sitemap</a>
                </li>
              </ul>
            </div>

          </div>
        </div>

        <div className="container">
          <div className="row">

            <div className="col-md-8 col-sm-6 col-xs-12">
              <p className="copyright-text">
                Copyright &copy; 2017 All Rights Reserved by
                <a href="#">Scanfcode</a>.
              </p>
            </div>

            <div className="col-md-4 col-sm-6 col-xs-12">
              <ul className="social-icons">
                <li>
                  <a className="facebook" href="#">
                    <i className="fa fa-facebook"></i>
                  </a>
                </li>

                <li>
                  <a className="twitter" href="#">
                    <i className="fa fa-twitter"></i>
                  </a>
                </li>

                <li>
                  <a className="dribbble" href="#">
                    <i className="fa fa-dribbble"></i>
                  </a>
                </li>

                <li>
                  <a className="linkedin" href="#">
                    <i className="fa fa-linkedin"></i>
                  </a>
                </li>
              </ul>
            </div>
            
          </div>
        </div>
      </footer>
    </div>
  );
};

export default Footer;
