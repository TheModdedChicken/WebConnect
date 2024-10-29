import type { Action } from 'svelte/action';

export const portal: Action<HTMLElement, boolean | undefined> = (node, priority = false) => {
  let container = document.getElementById('portal');
  if (!container) throw new Error(`Couldn't find portal container`);

  if (priority) container.prepend(node);
  else container.appendChild(node);

  return {
    destroy() {
      node.remove();
    }
  }
}

export function deportal(id: string) {
  document.getElementById("modal-" + id)?.remove();
}