use rand::Rng;

fn main() {
    let mut rng = rand::thread_rng();
    println!("STR: {}", rng.gen_range(3..19));
    println!("DEX: {}", rng.gen_range(3..19));
    println!("CON: {}", rng.gen_range(3..19));
    println!("INT: {}", rng.gen_range(3..19));
    println!("WIS: {}", rng.gen_range(3..19));
    println!("CHA: {}", rng.gen_range(3..19));
}