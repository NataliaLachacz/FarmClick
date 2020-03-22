export class CounterService {
  clicked = 0;
  coins = 0;
  price = 5;

  addClick() {
    this.clicked++;
    console.log(this.clicked);
    if (this.clicked >= 3) {
      this.addCoin();
    }
  }
  addCoin() {
    if (this.clicked % 3 === 0) {
      this.coins = this.coins + this.price;
    }
  }
}
