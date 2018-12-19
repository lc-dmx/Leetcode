class Solution {
    public int maxArea(int[] height) {
// 假设有左指针left和右指针right，且left指向的值小于right的值，假如我们将右指针左移，则右指针左移后的值和左指针指向的值相比有三种情况

// 右指针指向的值大于左指针
// 这种情况下，容器的高取决于左指针，但是底变短了，所以容器盛水量一定变小

// 右指针指向的值等于左指针
// 这种情况下，容器的高取决于左指针，但是底变短了，所以容器盛水量一定变小

// 右指针指向的值小于左指针
// 这种情况下，容器的高取决于右指针，但是右指针小于左指针，且底也变短了，所以容量盛水量一定变小了

// 综上所述，容器高度较大的一侧的移动只会造成容器盛水量减小
// 所以应当移动高度较小一侧的指针，并继续遍历，直至两指针相遇。
        int i = 0, j = height.length - 1;
        int result = 0;
        while(j > i){
    		int temp = Math.min(height[i], height[j]) * (j - i);
    		result = Math.max(result, temp);
    		if(height[i] < height[j]){
    			i++;
    		}else{
    			j--;
    		}
      
        }
		return result;
    }
}
