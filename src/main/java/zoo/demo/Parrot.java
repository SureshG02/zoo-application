package zoo.demo;

import java.util.List;
import java.util.Objects;

public class Parrot extends Birds {
	private boolean canSpeak;

	public Parrot(String name, String favouriteFood, String wingSpan, boolean canSpeak) {
		super(name, favouriteFood, wingSpan);
		this.canSpeak = canSpeak;
	}

	public boolean isCanSpeak() {
		return canSpeak;
	}

	public void setCanSpeak(boolean canSpeak) {
		this.canSpeak = canSpeak;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Parrot parrot = (Parrot) o;
		return canSpeak == parrot.canSpeak;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), canSpeak);
	}
}
