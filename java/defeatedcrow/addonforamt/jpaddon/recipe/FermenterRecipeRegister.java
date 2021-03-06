package defeatedcrow.addonforamt.jpaddon.recipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.oredict.OreDictionary;
import defeatedcrow.addonforamt.jpaddon.AJPLogger;
import defeatedcrow.addonforamt.jpaddon.api.IFermenterRecipe;
import defeatedcrow.addonforamt.jpaddon.api.IFermenterRecipeRegister;

public class FermenterRecipeRegister implements IFermenterRecipeRegister {

	private List<FermenterRecipe> recipes;

	public FermenterRecipeRegister() {
		this.recipes = new ArrayList<FermenterRecipe>();
	}

	@Override
	public void addRecipe(ItemStack output, int time, Object input) {
		if (output != null && input != null && time > 0) {
			recipes.add(new FermenterRecipe(input, output, time));
			AJPLogger.debugTrace("Add Fermenter recipe: output " + output.getDisplayName());
		}

	}

	@Override
	public List<? extends IFermenterRecipe> getRecipes() {
		return this.recipes;
	}

	@Override
	public IFermenterRecipe getRecipe(ItemStack input) {
		if (recipes.isEmpty()) {
			return null;
		} else {
			for (IFermenterRecipe recipe : recipes) {
				if (recipe.matches(input)) {
					return recipe;
				}
			}
			return null;
		}
	}

	public class FermenterRecipe implements IFermenterRecipe {

		private final Object input;
		private final ItemStack output;
		private int time;
		private ArrayList<ItemStack> processedInput;

		public FermenterRecipe(Object in, ItemStack out, int t) {
			this.input = in;
			this.output = out;
			this.time = t;
			processedInput = new ArrayList<ItemStack>();
			if (input instanceof String) {
				processedInput.addAll(OreDictionary.getOres((String) input));
			} else if (input instanceof ItemStack) {
				processedInput.add(((ItemStack) input).copy());
			} else if (input instanceof Item) {
				processedInput.add(new ItemStack((Item) input, 1, 0));
			} else if (input instanceof Block) {
				processedInput.add(new ItemStack((Block) input, 1, 0));
			} else {
				throw new IllegalArgumentException("Unknown Object passed to recipe!");
			}
		}

		@Override
		public Object getInput() {
			return this.input;
		}

		@Override
		public ArrayList<ItemStack> getProcessedInput() {
			return this.processedInput;
		}

		@Override
		public ItemStack getOutput() {
			return this.output == null ? null : this.output.copy();
		}

		@Override
		public ItemStack getSecondary(ItemStack in) {
			if (in == null) {
				return null;
			} else {
				ItemStack ret = in.getItem().getContainerItem(in);
				ItemStack con = null;
				if (FluidContainerRegistry.isFilledContainer(in)) {
					con = FluidContainerRegistry.drainFluidContainer(in);
				}
				if (ret != null) {
					return ret;
				} else if (con != null) {
					return con;
				} else {
					return null;
				}
			}
		}

		@Override
		public int getTime() {
			return this.time;
		}

		@Override
		public boolean matches(ItemStack item) {
			ArrayList<ItemStack> required = new ArrayList<ItemStack>(this.processedInput);
			if (item != null && item.getItem() != null && !required.isEmpty()) {
				Iterator<ItemStack> itr = required.iterator();
				boolean match = false;
				while (itr.hasNext() && !match) {
					match = OreDictionary.itemMatches(itr.next(), item, false);
				}
				return match;
			}
			return false;
		}

	}

}
